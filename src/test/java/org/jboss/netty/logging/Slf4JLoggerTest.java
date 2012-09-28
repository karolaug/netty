/*
 * JBoss, Home of Professional Open Source
 *
 * Copyright 2008, Red Hat Middleware LLC, and individual contributors
 * by the @author tags. See the COPYRIGHT.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.jboss.netty.logging;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

import org.junit.Test;


/**
 * @author The Netty Project (netty-dev@lists.jboss.org)
 * @author Trustin Lee (tlee@redhat.com)
 *
 * @version $Rev: 121 $, $Date: 2008-08-25 04:02:30 -0700 (Mon, 25 Aug 2008) $
 *
 */
public class Slf4JLoggerTest {
    private static final Exception e = new Exception();

    @Test
    public void testIsDebugEnabled() {
        org.slf4j.Logger mock =
            createStrictMock(org.slf4j.Logger.class);

        expect(mock.isDebugEnabled()).andReturn(true);
        replay(mock);

        InternalLogger logger = new Slf4JLogger(mock);
        assertTrue(logger.isDebugEnabled());
        verify(mock);
    }

    @Test
    public void testIsInfoEnabled() {
        org.slf4j.Logger mock =
            createStrictMock(org.slf4j.Logger.class);

        expect(mock.isInfoEnabled()).andReturn(true);
        replay(mock);

        InternalLogger logger = new Slf4JLogger(mock);
        assertTrue(logger.isInfoEnabled());
        verify(mock);
    }

    @Test
    public void testIsWarnEnabled() {
        org.slf4j.Logger mock =
            createStrictMock(org.slf4j.Logger.class);

        expect(mock.isWarnEnabled()).andReturn(true);
        replay(mock);

        InternalLogger logger = new Slf4JLogger(mock);
        assertTrue(logger.isWarnEnabled());
        verify(mock);
    }

    @Test
    public void testIsErrorEnabled() {
        org.slf4j.Logger mock =
            createStrictMock(org.slf4j.Logger.class);

        expect(mock.isErrorEnabled()).andReturn(true);
        replay(mock);

        InternalLogger logger = new Slf4JLogger(mock);
        assertTrue(logger.isErrorEnabled());
        verify(mock);
    }

    @Test
    public void testDebug() {
        org.slf4j.Logger mock =
            createStrictMock(org.slf4j.Logger.class);

        mock.debug("a");
        replay(mock);

        InternalLogger logger = new Slf4JLogger(mock);
        logger.debug("a");
        verify(mock);
    }

    @Test
    public void testDebugWithException() {
        org.slf4j.Logger mock =
            createStrictMock(org.slf4j.Logger.class);

        mock.debug("a", e);
        replay(mock);

        InternalLogger logger = new Slf4JLogger(mock);
        logger.debug("a", e);
        verify(mock);
    }

    @Test
    public void testInfo() {
        org.slf4j.Logger mock =
            createStrictMock(org.slf4j.Logger.class);

        mock.info("a");
        replay(mock);

        InternalLogger logger = new Slf4JLogger(mock);
        logger.info("a");
        verify(mock);
    }

    @Test
    public void testInfoWithException() {
        org.slf4j.Logger mock =
            createStrictMock(org.slf4j.Logger.class);

        mock.info("a", e);
        replay(mock);

        InternalLogger logger = new Slf4JLogger(mock);
        logger.info("a", e);
        verify(mock);
    }

    @Test
    public void testWarn() {
        org.slf4j.Logger mock =
            createStrictMock(org.slf4j.Logger.class);

        mock.warn("a");
        replay(mock);

        InternalLogger logger = new Slf4JLogger(mock);
        logger.warn("a");
        verify(mock);
    }

    @Test
    public void testWarnWithException() {
        org.slf4j.Logger mock =
            createStrictMock(org.slf4j.Logger.class);

        mock.warn("a", e);
        replay(mock);

        InternalLogger logger = new Slf4JLogger(mock);
        logger.warn("a", e);
        verify(mock);
    }

    @Test
    public void testError() {
        org.slf4j.Logger mock =
            createStrictMock(org.slf4j.Logger.class);

        mock.error("a");
        replay(mock);

        InternalLogger logger = new Slf4JLogger(mock);
        logger.error("a");
        verify(mock);
    }

    @Test
    public void testErrorWithException() {
        org.slf4j.Logger mock =
            createStrictMock(org.slf4j.Logger.class);

        mock.error("a", e);
        replay(mock);

        InternalLogger logger = new Slf4JLogger(mock);
        logger.error("a", e);
        verify(mock);
    }
}
