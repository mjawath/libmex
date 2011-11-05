/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.biz.app.ui.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.text.JTextComponent;

/**
 *
 * @author nano
 */
public class uiEty {

    public static  void setcombomodel(String[] str, JComboBox box) {
        box.setModel(new DefaultComboBoxModel(str));
    }

    public static String doubleToUI(Number d) {
        if (d == null) {
            return "";
        }
        return d.toString();

    }

    public static String objToUI(Object d) {
        if (d == null) {
            return "";
        }
        return d.toString();

    }

    public static Double uiToDouble(String dbl) {

        try {
            String s = null;
            if (dbl != null) {
                s = dbl.trim();
            }
            return Double.parseDouble(s);
        } catch (Exception e) {
            return null;
        }

    }

    public static Double uiToDouble(Object dbl) {

        try {
            String s = null;
            if (dbl != null) {
                s = dbl.toString().trim();
            }
            return Double.parseDouble(s);
        } catch (Exception e) {
            return null;
        }

    }

    public static Long uiToLong(Object dbl) {

        try {
            String s = null;
            if (dbl != null) {
                s = dbl.toString().trim();
            }
            return Long.parseLong(s);
        } catch (Exception e) {
            return null;
        }

    }

    public static Long uiToLong0(Object dbl) {

        try {
            String s = null;
            if (dbl != null) {
                s = dbl.toString().trim();
            }
            return Long.parseLong(s);
        } catch (Exception e) {
            return 0l;
        }

    }

    public static double uiToDbl0(Object dbl) {

        try {
            String s = null;
            if (dbl != null) {
                s = dbl.toString().trim();
            }
            return Double.parseDouble(s);
        } catch (Exception e) {
            return 0;
        }

    }

    public static Double tcToDouble(JTextComponent txtcom) {

        try {
            String s = null;
            if (txtcom.getText() != null) {
                s = txtcom.getText().trim();

            }
            return Double.parseDouble(s);
        } catch (Exception e) {
            return null;
        }

    }

    public static double tcToDble0(JTextComponent txtcom) {

        try {
            String s = null;
            if (txtcom.getText() != null) {
                s = txtcom.getText().trim();

            }
            return Double.parseDouble(s);
        } catch (Exception e) {
            return 0.0;
        }

    }

    public static long tcToLong0(JTextComponent txtcom) {

        try {
            String s = null;
            if (txtcom.getText() != null) {
                s = txtcom.getText().trim();

            }
            return Long.parseLong(s);
        } catch (Exception e) {
            return 0l;
        }

    }

    public static Long tcToLong(JTextComponent txtcom) {

        try {
            String s = null;
            if (txtcom.getText() != null) {
                s = txtcom.getText().trim();

            }
            return Long.parseLong(s);
        } catch (Exception e) {
            return null;
        }

    }

    public static Integer tcToInt(JTextComponent txtcom) {

        try {
            String s = null;
            if (txtcom.getText() != null) {
                s = txtcom.getText().trim();
            }
            return Integer.parseInt(s);
        } catch (Exception e) {
            return null;
        }

    }

    public static String uiToString(Object object) {
        if (object == null) {
            return null;
        } else {
            return object.toString().trim();
        }
    }

    public static String etyToStr(Object object) {
        if (object == null) {
            return "";
        } else {
            return object.toString().trim();
        }
    }

    public static String tcToStrE(JTextComponent txtcom) {
        if (txtcom.getText() == null) {
            return "";
        } else {
            return txtcom.getText().trim();
        }
    }

    public static String tcToStr(JTextComponent txtcom) {
        String x = txtcom.getText().trim();
        if (x.isEmpty()) {
            return null;
        } else {
            return x;
        }
    }

    public static String cmbtostr(JComboBox jcb) {
        Object obj = null;
        if (jcb.isEditable()) {
            obj = jcb.getEditor().getItem();
        } else {
            obj = jcb.getSelectedItem();
        }
        if (obj != null) {
            return obj.toString();
        } else {
            return null;
        }

    }

    public static String dpToDate(Date date) {
        Object obj = date;
        if (obj != null) {
            return obj.toString();
        } else {
            return null;
        }

    }

    public static String getPlainDouble(Double value) {
        return new BigDecimal(value).setScale(2, RoundingMode.HALF_UP).toPlainString();
    }

    public static String getPlainDouble(String value) {
        return new BigDecimal(value).setScale(2, RoundingMode.HALF_UP).toPlainString();
    }

    public static String objTodate(Object d) {
        if (d == null) {
            return "";
        }
        return new SimpleDateFormat("dd/MMM/yyyy").format(d);

    }

    public static String objTodate(String form, Object d) {
        if (d == null) {
            return "";
        }
        try {
            return new SimpleDateFormat(form).format(d);

        } catch (Exception e) {
        }
        return "";
    }

    public static void objToUi(JTextComponent jtc, Object val) {
        if (val != null) {
            jtc.setText(val.toString());
        } else {
            jtc.setText("");
        }

    }

    public static void objToUi(JLabel jtc, Object val) {
        if (val != null) {
            jtc.setText(val.toString());
        } else {
            jtc.setText("");
        }

    }

    public static void objToUi(JComboBox jtc, Object val) {
        if (val != null) {
            jtc.setSelectedItem(val.toString());
        }
    }

    public static String now() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        return sdf.format(date);

    }

    public static Date nowDate() {
        Date date = new Date();
        return date;

    }

    public static String nowTime() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        return sdf.format(date);

    }

    public static void main(String[] args) {
        System.out.println(new Date());
    }
}