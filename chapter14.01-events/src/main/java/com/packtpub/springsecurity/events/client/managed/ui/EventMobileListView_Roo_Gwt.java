// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.

package com.packtpub.springsecurity.events.client.managed.ui;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.text.client.DateTimeFormatRenderer;
import com.google.gwt.text.shared.AbstractRenderer;
import com.google.gwt.text.shared.AbstractSafeHtmlRenderer;
import com.google.gwt.text.shared.Renderer;
import com.google.gwt.text.shared.SafeHtmlRenderer;
import com.packtpub.springsecurity.events.client.proxy.EventProxy;
import com.packtpub.springsecurity.events.client.scaffold.ScaffoldMobileApp;
import com.packtpub.springsecurity.events.client.scaffold.ui.MobileProxyListView;
import java.util.HashSet;
import java.util.Set;

public abstract class EventMobileListView_Roo_Gwt extends MobileProxyListView<EventProxy> {

    protected Set<String> paths = new HashSet<String>();

    public EventMobileListView_Roo_Gwt(String buttonText, SafeHtmlRenderer<com.packtpub.springsecurity.events.client.proxy.EventProxy> renderer) {
        super(buttonText, renderer);
    }

    public void init() {
        paths.add("description");
        paths.add("id");
    }
}
