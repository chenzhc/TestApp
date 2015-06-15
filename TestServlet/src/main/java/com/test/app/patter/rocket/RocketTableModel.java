package com.test.app.patter.rocket;

import javax.swing.table.AbstractTableModel;

/**
 * Created by zc on 2015/6/15.
 */
public class RocketTableModel extends AbstractTableModel {

    private Rocket[] rockets;
    private String[] columnNames;

    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public int getColumnCount() {
        return 0;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
    }
}
