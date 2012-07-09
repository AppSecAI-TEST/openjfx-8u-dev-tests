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
package org.jemmy.samples.combobox;


import java.util.Date;
import org.jemmy.action.GetAction;
import org.jemmy.fx.SceneDock;
import org.jemmy.fx.control.ChoiceBoxDock;
import org.jemmy.fx.control.ComboBoxDock;
import org.jemmy.interfaces.Keyboard;
import org.jemmy.interfaces.Selectable;
import org.jemmy.samples.SampleBase;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;


public class ComboBoxSample extends SampleBase {
    private static SceneDock scene;
    private static ComboBoxDock comboBox1;
    private static ComboBoxDock comboBox2;
    private static ComboBoxDock comboBox3;
    private static ChoiceBoxDock choiceBox;
    
    @BeforeClass
    public static void launch() throws InterruptedException {
        // Running the test application
        startApp(ComboBoxApp.class);
        
        // Obtaining a Dock for scene
        scene = new SceneDock();

        /**
        * Looking up for Combo and Choice boxes. The best option is to do that 
        * by id.
        */
        comboBox1 = new ComboBoxDock(scene.asParent(), "combo");
        comboBox2 = new ComboBoxDock(scene.asParent(), "records-combo");
        comboBox3 = new ComboBoxDock(scene.asParent(), "countries-combo");
        choiceBox = new ChoiceBoxDock(scene.asParent(), "choice-box");
    }

    /**
     * Selecting an item by the item object itself in ComboBox and ChoiceBox.
     */
    @Test
    public void selectItemByItemObject() {
        comboBox1.selector().select("Item 1");
        choiceBox.selector().select(1984);
    }
    
    /**
     * Checking what item is selected.
     */
    @Test
    public void getSelectedItem() {
        Object selected1 = comboBox1.asSelectable().getState();
        System.out.println("Selected value in comboBox1 = " + selected1);
        
        Object selected2 = choiceBox.asSelectable().getState();
        System.out.println("Selected value in choiceBox = " + selected2);
    }

    /**
     * Selecting an item by item index. 
     */
    @Test
    public void selectItemByIndex() {
        int itemIndex = 20;
        // TODO: The API is insufficient in this area http://javafx-jira.kenai.com/browse/JMY-143
        // so we just obtain the item from the list of all items
        Object item = comboBox2.asSelectable().getStates().get(itemIndex);
        
        // and select it
        comboBox2.selector().select(item);
    }
    
    /**
     * Getting selected item index.
     */
    @Test
    public void getSelectedIndex() {
        // TODO: The API is insufficient in this area http://javafx-jira.kenai.com/browse/JMY-143
        // so we need to access ComboBox object directly as described in 
        // accessComboBoxDirectly() method.
        int selectedIndex = new GetAction<Integer>() {

            @Override
            public void run(Object... args) throws Exception {
                setResult(comboBox2.control().getSelectionModel().getSelectedIndex());
            }
        }.dispatch(comboBox2.wrap().getEnvironment());
        
        System.out.println("Selected item index in comboBox2 = " + selectedIndex);
    }
    
    /**
     * Accessing ComboBox object directly.
     * 
     * This *must* be done on JavaFX thread. Use Jemmy GetAction.dispatch() 
     * functionality to achieve that.
     */
    @Test
    public void accessComboBoxDirectly() {
        boolean hasOnAction = new GetAction<Boolean>() {

            /**
             * the body of this method will be invoked on JavaFX thread
             * so we can access ComboBox object directly
             */
            @Override
            public void run(Object... args) throws Exception {
                // setting result of GetAction.dispatch() method.
                setResult(comboBox2.control().getOnAction() != null);
            }
        }.dispatch(comboBox2.wrap().getEnvironment());
        
        System.out.println("comboBox2 has onAction function = " + hasOnAction);
    }
    
    /**
     * Selecting an item of specific type
     */
    @Ignore @Test
    public void selectItemByTypeAndIndex() {
        // TODO: Doesn't work yet due to http://javafx-jira.kenai.com/browse/JMY-144     
        Selectable<Date> selectable = comboBox1.wrap().as(Selectable.class, Date.class);
        Date d = selectable.getStates().get(0);
        System.out.println("selectable.getStates() = " + selectable.getStates());
        System.out.println("d = " + d);
        selectable.selector().select(selectable.getStates().get(0));
    }
    
    /**
     * Entering a value into editable ComboBox
     */
    @Test
    public void enterValue() {
        String value = "Lithuania";
        comboBox3.type(value);
        comboBox3.keyboard().pushKey(Keyboard.KeyboardButtons.ENTER);
    }
    
    /**
     * Getting ComboBox value
     */
    @Test
    public void getValue() {
        Object value = comboBox3.getValue();
        System.out.println("comboBox3 value = " + value);
    }
}
