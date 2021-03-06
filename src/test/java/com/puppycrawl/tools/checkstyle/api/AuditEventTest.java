////////////////////////////////////////////////////////////////////////////////
// checkstyle: Checks Java source code for adherence to a set of rules.
// Copyright (C) 2001-2019 the original author or authors.
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License, or (at your option) any later version.
//
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
// Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public
// License along with this library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
////////////////////////////////////////////////////////////////////////////////

package com.puppycrawl.tools.checkstyle.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class AuditEventTest {

    @Test
    public void test() {
        final AuditEvent event = new AuditEvent(getClass());

        assertNull("invalid file name", event.getFileName());
        assertNull("invalid localized message", event.getLocalizedMessage());
        assertEquals("invalid source", getClass(), event.getSource());
        assertEquals("invalid severity", SeverityLevel.INFO, event.getSeverityLevel());
    }

    @Test
    public void testFullConstructor() {
        final LocalizedMessage message = new LocalizedMessage(1, 2, 3, "bundle", "key", null,
                SeverityLevel.ERROR, "moduleId", getClass(), "customMessage");
        final AuditEvent event = new AuditEvent(getClass(), "fileName", message);

        assertEquals("invalid file name", "fileName", event.getFileName());
        assertEquals("invalid localized message", message, event.getLocalizedMessage());
        assertEquals("invalid message", "customMessage", event.getMessage());
        assertEquals("invalid source", getClass(), event.getSource());
        assertEquals("invalid line", 1, event.getLine());
        assertEquals("invalid column", 2, event.getColumn());
        assertEquals("invalid severity", SeverityLevel.ERROR, event.getSeverityLevel());
        assertEquals("invalid module id", "moduleId", event.getModuleId());
        assertEquals("invalid source name", "com.puppycrawl.tools.checkstyle.api.AuditEventTest",
                event.getSourceName());
    }
}
