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

import com.sun.javafx.runtime.VersionInfo;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class IncludeControllerApp extends Application{
    
    private static String FXML_RESOURCE = "/test/fxmltests/resources/main_controller.fxml";
    
    @Override
    public void start(Stage stage) throws Exception {
        initialize(stage);
        stage.show();
    }
    
    private void initialize (Stage stage) {
        stage.setTitle(VersionInfo.getRuntimeVersion());
        try {
            Pane root = (Pane) FXMLLoader.load(getClass().getResource(FXML_RESOURCE));
            Scene scene = new Scene(root, 500, 500);
            stage.setScene(scene);
        }
        catch (Exception exc) {
            throw new RuntimeException(exc);
        }
    }
    
    public static void main (String[] args) {
        launch(args);
    }
    
    public static void reset () {
        IncludeController.reset();
        MainController.reset();
    }
}