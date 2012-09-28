/*
 * JBoss, Home of Professional Open Source
 *
 * Copyright 2009, Red Hat Middleware LLC, and individual contributors
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
package org.jboss.netty.example.http.tunnel;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.local.DefaultLocalServerChannelFactory;
import org.jboss.netty.channel.local.LocalAddress;
import org.jboss.netty.example.echo.EchoHandler;

/**
 * Deploy this in JBossAS 5 by adding the following bean.
 *
 * <pre>
 * &lt;bean name="org.jboss.netty.example.http.tunnel.LocalTransportRegister"
 *       class="org.jboss.netty.example.http.tunnel.LocalTransportRegister" /&gt;
 * </pre>
 *
 * @author The Netty Project (netty-dev@lists.jboss.org)
 * @author Andy Taylor (andy.taylor@jboss.org)
 * @version $Rev: 1482 $, $Date: 2009-06-19 10:48:17 -0700 (Fri, 19 Jun 2009) $
 */
public class LocalTransportRegister {

    private final ChannelFactory factory = new DefaultLocalServerChannelFactory();
    private volatile Channel serverChannel;

    public void start() {
        ServerBootstrap serverBootstrap = new ServerBootstrap(factory);
        EchoHandler handler = new EchoHandler();
        serverBootstrap.getPipeline().addLast("handler", handler);
        serverChannel = serverBootstrap.bind(new LocalAddress("myLocalServer"));
    }

    public void stop() {
        serverChannel.close();
    }
}
