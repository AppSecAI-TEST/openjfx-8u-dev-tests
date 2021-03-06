/*
 * Copyright (c) 2009, 2012, Oracle and/or its affiliates. All rights reserved.
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

package org.jemmy.fx.control;

import java.awt.AWTException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * This small FX app is used in ColorPicker JemmyFX samples. It displays an ColorPicker control.
 *
 */

public class ColorPickerApp extends Application {
    /**
     *
     * @param args
     * @throws AWTException
     */
    public static void main(String[] args) throws AWTException {
        launch(args);
    }

    /**
     *
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        VBox box = new VBox();
        Scene scene = new Scene(box);

        box.setSpacing(10);

        ColorPicker picker = new ColorPicker();
        picker.setId("picker id");

        Rectangle rect = new Rectangle(50, 50);
        rect.setId("rect id");

        rect.fillProperty().bind(picker.valueProperty());

        box.getChildren().addAll(picker, rect);

        stage.setScene(scene);

        stage.setWidth(300);
        stage.setHeight(300);

        stage.show();
    }
}
