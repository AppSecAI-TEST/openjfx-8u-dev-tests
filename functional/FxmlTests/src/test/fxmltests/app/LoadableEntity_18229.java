/*
 * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation. Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

package test.fxmltests.app;


import com.sun.javafx.beans.IDProperty;
//import com.sun.javafx.fxml.PropertyName;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;

@IDProperty("id")
public class LoadableEntity_18229 {
    private StringProperty id = new SimpleStringProperty();
    private StringProperty name1 = new SimpleStringProperty();
    private StringProperty name2 = new SimpleStringProperty();
    private ObservableMap<String, Object> properties = FXCollections.observableHashMap();

    public LoadableEntity_18229() {
        this(null);
    }

    public LoadableEntity_18229(String name) {
        setName1(name);
    }

    //@PropertyName("id")
    public String getId() {
        return id.get();
    }

    public void setId(String value) {
        id.set(value);
    }

    public StringProperty idProperty() {
        return id;
    }

   // @PropertyName("name1")
    public String getName1() {
        return name1.get();
    }

    public void setName1(String value) {
        name1.set(value);
    }

    public StringProperty name1Property() {
        return name1;
    }

    //@PropertyName("name2")
    public String getName2() {
        return name2.get();
    }

    public void setName2(String value) {
        name2.set(value);
    }

    public StringProperty name2Property() {
        return name2;
    }

    public ObservableMap<String, Object> getProperties() {
        return properties;
    }
}
