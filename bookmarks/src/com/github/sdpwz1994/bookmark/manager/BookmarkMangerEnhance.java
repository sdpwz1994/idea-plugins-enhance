package com.github.sdpwz1994.bookmark.manager;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import org.jdom.Element;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author sundapeng
 * @version 1.0
 * @date 2020/12/16
 */
@State(
        name = "BookmarkManager",
        storages = {@Storage("$WORKSPACE_FILE$")}
)
public class BookmarkMangerEnhance implements PersistentStateComponent<Element> {


    @Nullable
    @Override
    public Element getState() {
        return null;
    }

    @Override
    public void loadState(@NotNull Element element) {

    }
}
