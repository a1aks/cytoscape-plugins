/*
 * KAM Navigator Plugin
 *
 * URLs: http://openbel.org/
 * Copyright (C) 2012, Selventa
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.openbel.belframework.kam.task;

import java.util.List;

import org.openbel.belframework.kam.KAMNetwork;
import org.openbel.belframework.kam.Utility;

import com.selventa.belframework.ws.client.EdgeDirectionType;
import com.selventa.belframework.ws.client.KamNode;

import cytoscape.task.Task;

/**
 * {@link KAMTasks} defines a wrapper to call supported, long-running
 * {@link Task cytoscape tasks}.
 *
 * @author Anthony Bargnesi &lt;abargnesi@selventa.com&gt;
 */
public class KAMTasks {

    /**
     * Call the {@link AddNodeTask add node task}.
     *
     * @see AddNodeTask#run()
     * @param kamNetwork the {@link KAMNetwork kam network} to add to
     * @param kamNodes the {@link KamNode kam nodes} to add
     */
    public static void addNodes(final KAMNetwork kamNetwork, final List<KamNode> kamNodes) {
        final AddNodeTask task = new AddNodeTask(kamNetwork, kamNodes);
        Utility.executeTask(task);
    }

    /**
     * Call the {@link NodeEdgesTask node edges task}.
     *
     * @see NodeEdgesTask#run()
     * @param kamNetwork the {@link KAMNetwork kam network} to add to
     * @param kamNodes the {@link KamNode kam nodes} to expand
     */
    public static void expandNodes(final KAMNetwork kamNetwork, final List<KamNode> kamNodes,
            final EdgeDirectionType direction) {
        final NodeEdgesTask task = new NodeEdgesTask(kamNetwork, kamNodes, direction);
        Utility.executeTask(task);
    }

    /**
     * Call the {@link InterconnectNodesTask interconnect nodes task}.
     *
     * @see InterconnectNodesTask#run()
     * @param kamNetwork the {@link KAMNetwork kam network} to add to
     * @param kamNodes the {@link KamNode kam nodes} to interconnect
     */
    public static void interconnect(final KAMNetwork kamNetwork, final List<KamNode> kamNodes) {
        final InterconnectNodesTask task = new InterconnectNodesTask(kamNetwork, kamNodes);
        Utility.executeTask(task);
    }

    private KAMTasks() {
        // prevent instantiation
    }
}