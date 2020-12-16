package com.github.sdpwz1994.bookmark.provider;

import com.intellij.ide.bookmarks.BookmarkManager;
import com.intellij.ide.bookmarks.BookmarksFavoriteListProvider;
import com.intellij.ide.favoritesTreeView.FavoritesManager;
import com.intellij.openapi.project.Project;

/**
 * @author sundapeng
 * @version 1.0
 * @date 2020/12/16
 */
public class BookmarksFavoriteListProviderEnhance extends BookmarksFavoriteListProvider {

    public BookmarksFavoriteListProviderEnhance(Project project, BookmarkManager bookmarkManager, FavoritesManager favoritesManager) {
        super(project, bookmarkManager, favoritesManager);
    }



}
