package actions;

import database.*;
import fileio.ActionInput;
import helpers.Constants;
import observer.MyObservable;
import observer.MyObserver;
import server.Navigator;

import java.util.ArrayList;

public final class DatabaseDelete extends ActionStrategy implements MyObservable {
    private String feature;
    private String deletedMovie;

    private ArrayList<MyObserver> observers = new ArrayList<>();

    public DatabaseDelete(final ActionInput action) {
        super(action.getType());
        feature = action.getFeature();
        deletedMovie = action.getDeletedMovie();
    }

    @Override
    public void actionStrategy(final Navigator navigator) {
        Movie movie = getMovie(MoviesDatabase.getInstance().getMovies(), deletedMovie);

        /**
         * Checking if there is a movie with such name in the movie Database
         */
        if (movie == null) {
            setError();
            return;
        }

        /**
         * Set the notification
         */
        Notification notification = new Notification(deletedMovie, Constants.DELETE_NOTIFICATION);

        /**
         * Set the observers and notify them
         */
        setObservers(UsersDatabase.getInstance().getUsers());
        notifyObservers(notification);

        /**
         * Removing the movie from the movie Database
         */
        MoviesDatabase.getInstance().getMovies().remove(movie);
    }

    /**
     * Filter the potential observers based on a purchased movie
     * In addition, preemptively removes the movie from all the potential lists
     * of a user
     * @param potentialObservers users that could be observers
     */
    @Override
    public void setObservers(final ArrayList<User> potentialObservers) {
        for (User user : potentialObservers) {
            /**
             * Remove a purchased movie from the purchased movie list
             */
            Movie purchasedMovie = getMovie(user.getPurchasedMovies(), deletedMovie);

            if (purchasedMovie != null) {
                user.getPurchasedMovies().remove(purchasedMovie);
                observers.add(user);
                returnTokens(user);
            }

            /**
             * Remove a watched movie from the watched movie list
             */
            Movie watchedMovie = getMovie(user.getWatchedMovies(), deletedMovie);

            if (watchedMovie != null) {
                user.getWatchedMovies().remove(watchedMovie);
            }

            /**
             * Remove a liked movie from the liked movie list
             */
            Movie likedMovie = getMovie(user.getLikedMovies(), deletedMovie);

            if (likedMovie != null) {
                user.getLikedMovies().remove(likedMovie);
            }

            /**
             * Remove a rated movie from the rated movie list
             */
            Movie ratedMovie = getMovie(user.getRatedMovies(), deletedMovie);

            if (ratedMovie != null) {
                user.getRatedMovies().remove(ratedMovie);
            }

            /**
             * Remove an asynchronous movie from the asynchronous movie list
             */
            Movie asynchronousMovie = getMovie(user.getAsynchronousMovies(), deletedMovie);

            if (asynchronousMovie != null) {
                user.getAsynchronousMovies().remove(asynchronousMovie);
            }
        }
    }

    /**
     * Notify all observers
     * @param arg notification
     */
    @Override
    public void notifyObservers(final Object arg) {
        observers.forEach(observers -> observers.update(this, arg));
    }

    /**
     * Returning a premium movie (for a premium user) or tokens (for a regular user)
     * while removing a movie from the movie Database, based on account type
     * @param user user that we are returning a premium movie/ tokens to
     */
    public void returnTokens(final User user) {
        if (user.getCredentials().getAccountType().equals(Constants.PREMIUM)) {
            user.setNumFreePremiumMovies(user.getNumFreePremiumMovies() + 1);
        } else {
            user.setTokensCount(user.getTokensCount() + 2);
        }
    }
}
