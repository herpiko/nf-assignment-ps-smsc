/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableModel;
import javax.swing.ListModel;
import java.util.ArrayList;
import java.util.List;
import net.proteanit.sql.DbUtils;
import Model.InboxModel;
import DB.DB;

/**
 *
 * @author herpiko
 */
public class InboxDAO {
    
    DB DBConnect = null;

    public InboxDAO() {
        DBConnect = new DB();
    }
    
    public TableModel tableInbox() {
        TableModel model = new DefaultTableModel();
        String sql = "SELECT TextDecoded as Text, SenderNumber FROM inbox ORDER BY id";
        try {
            PreparedStatement pst = DBConnect.getConnection().prepareStatement(sql, ResultSet.CONCUR_UPDATABLE);
            //ResultSet.CONCUR_UPDATABLE;
            ResultSet rs = pst.executeQuery();
            model = DbUtils.resultSetToTableModel(rs);
        } catch (SQLException e) {
            System.out.println("ERROR " + e);
        }
        return model;
    }
   
}
