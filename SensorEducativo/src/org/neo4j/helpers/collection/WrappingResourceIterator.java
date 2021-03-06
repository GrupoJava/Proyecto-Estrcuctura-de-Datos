/**
 * Copyright (c) 2002-2013 "Neo Technology,"
 * Network Engine for Objects in Lund AB [http://neotechnology.com]
 *
 * This file is part of Neo4j.
 *
 * Neo4j is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.neo4j.helpers.collection;

import org.neo4j.graphdb.ResourceIterator;

import java.util.Iterator;

public class WrappingResourceIterator<T> implements ResourceIterator<T>
{
    private final Iterator<T> iterator;
    boolean hasNext;

    public WrappingResourceIterator(Iterator<T> iterator)
    {
        this.iterator = iterator;
        hasNext = iterator.hasNext();
    }

    @Override
    public void close()
    {
        hasNext = false;
    }

    @Override
    public boolean hasNext()
    {
        return hasNext;
    }

    @Override
    public T next()
    {
        assertHasNext();
        T result = iterator.next();
        hasNext = iterator.hasNext();
        return result;
    }

    @Override
    public void remove()
    {
        assertHasNext();
        try
        {
            iterator.remove();
        }
        finally
        {
            hasNext = iterator.hasNext();
        }
    }

    private void assertHasNext()
    {
        if ( ! hasNext )
        {
            throw new IllegalArgumentException( "Iterator already closed" );
        }
    }
}
