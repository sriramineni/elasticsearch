/*
 * Copyright Elasticsearch B.V. and/or licensed to Elasticsearch B.V. under one
 * or more contributor license agreements. Licensed under the Elastic License;
 * you may not use this file except in compliance with the Elastic License.
 */
package org.elasticsearch.shield.support;

import org.elasticsearch.ElasticsearchSecurityException;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.shield.Security;

/**
 *
 */
public class Exceptions {

    private Exceptions() {
    }

    public static ElasticsearchSecurityException authenticationError(String msg, Throwable cause, Object... args) {
        ElasticsearchSecurityException e = new ElasticsearchSecurityException(msg, RestStatus.UNAUTHORIZED, cause, args);
        e.addHeader("WWW-Authenticate", "Basic realm=\"" + Security.NAME + "\" charset=\"UTF-8\"");
        return e;
    }

    public static ElasticsearchSecurityException authenticationError(String msg, Object... args) {
        ElasticsearchSecurityException e = new ElasticsearchSecurityException(msg, RestStatus.UNAUTHORIZED, args);
        e.addHeader("WWW-Authenticate", "Basic realm=\"" + Security.NAME + "\" charset=\"UTF-8\"");
        return e;
    }

    public static ElasticsearchSecurityException authorizationError(String msg, Object... args) {
        return new ElasticsearchSecurityException(msg, RestStatus.FORBIDDEN, args);
    }
}
