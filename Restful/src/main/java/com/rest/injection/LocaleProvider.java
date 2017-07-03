/*package com.hp.rest.injection;

import java.util.List;
import java.util.Locale;

import javax.ws.rs.ext.Provider;

import com.sun.jersey.api.core.HttpContext;

@Provider
public class LocaleProvider extends AbstractInjectableProvider<Locale> {
    public LocaleProvider() {
        super(Locale.class);
    }

    @Override
    public Locale getValue(HttpContext c) {
        final List<Locale> locales = c.getRequest().getAcceptableLanguages();
        if (locales.isEmpty()) {
          return Locale.US;
        }
        return locales.get(0);
    }
}*/