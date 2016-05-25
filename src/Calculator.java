
import java.awt.event.*;
import java.math.*;

public class Calculator extends javax.swing.JFrame {
    
    private boolean zerodisp;//Zero is displayed
    private boolean decdisp;//Decimal is displayed
    private boolean dgrrad;//False if degrees, True if Radians
    private boolean sh;//Shift type of of function (F - goniometric/ T - Hyperbolical)
    
    private int min = -100000000, max = 100000000;
    private double oneDegInRad = 0.0174532925;
    
    private int intOperationModifier;//Used to compound operations and set next operation to be compounded
    
    private double inputA;
    private double inputB;
    private double doubleOutput;

    public Calculator() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        display2 = new javax.swing.JTextField();
        display1 = new javax.swing.JTextField();
        memorydisplay = new javax.swing.JTextField();
        memoryread = new javax.swing.JButton();
        memoryclear = new javax.swing.JButton();
        memorysave = new javax.swing.JButton();
        onedividedbyx = new javax.swing.JButton();
        percent = new javax.swing.JButton();
        pi = new javax.swing.JButton();
        cos = new javax.swing.JButton();
        tan = new javax.swing.JButton();
        sin = new javax.swing.JButton();
        seven = new javax.swing.JButton();
        eight = new javax.swing.JButton();
        nine = new javax.swing.JButton();
        add = new javax.swing.JButton();
        squared = new javax.swing.JButton();
        subtract = new javax.swing.JButton();
        squareroot = new javax.swing.JButton();
        multiply = new javax.swing.JButton();
        cubed = new javax.swing.JButton();
        divide = new javax.swing.JButton();
        cuberoot = new javax.swing.JButton();
        four = new javax.swing.JButton();
        five = new javax.swing.JButton();
        six = new javax.swing.JButton();
        one = new javax.swing.JButton();
        two = new javax.swing.JButton();
        three = new javax.swing.JButton();
        negate = new javax.swing.JButton();
        decpoint = new javax.swing.JButton();
        zero = new javax.swing.JButton();
        degrees = new javax.swing.JRadioButton();
        radians = new javax.swing.JRadioButton();
        equals = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        shift = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Java Calculator");
        setResizable(false);

        display2.setBackground(new java.awt.Color(199, 218, 220));
        display2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        display2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        display2.setFocusable(false);

        display1.setBackground(new java.awt.Color(199, 218, 220));
        display1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        display1.setText("0");
        display1.setAutoscrolls(false);
        display1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        display1.setFocusable(false);

        memorydisplay.setBackground(new java.awt.Color(199, 218, 220));
        memorydisplay.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        memorydisplay.setText("0");
        memorydisplay.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        memorydisplay.setFocusable(false);

        memoryread.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        memoryread.setText("MR");
        memoryread.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        memoryread.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        memoryread.setFocusable(false);
        memoryread.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                memoryreadActionPerformed(evt);
            }
        });

        memoryclear.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        memoryclear.setText("MC");
        memoryclear.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        memoryclear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        memoryclear.setFocusable(false);
        memoryclear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                memoryclearActionPerformed(evt);
            }
        });

        memorysave.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        memorysave.setText("MS");
        memorysave.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        memorysave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        memorysave.setFocusable(false);
        memorysave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                memorysaveActionPerformed(evt);
            }
        });

        onedividedbyx.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        onedividedbyx.setText("1/x");
        onedividedbyx.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        onedividedbyx.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        onedividedbyx.setFocusable(false);
        onedividedbyx.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                onedividedbyxActionPerformed(evt);
            }
        });

        percent.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        percent.setText("%");
        percent.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        percent.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        percent.setFocusable(false);
        percent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                percentActionPerformed(evt);
            }
        });

        pi.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        pi.setText("Π");
        pi.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pi.setFocusable(false);
        pi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                piActionPerformed(evt);
            }
        });

        cos.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        cos.setText("Cos");
        cos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cos.setFocusable(false);
        cos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                cosActionPerformed(evt);
            }
        });

        tan.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        tan.setText("Tan");
        tan.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tan.setFocusable(false);
        tan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                tanActionPerformed(evt);
            }
        });

        sin.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        sin.setText("Sin");
        sin.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        sin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sin.setFocusable(false);
        sin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                sinActionPerformed(evt);
            }
        });

        seven.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        seven.setText("7");
        seven.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        seven.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        seven.setFocusable(false);
        seven.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                sevenActionPerformed(evt);
            }
        });

        eight.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        eight.setText("8");
        eight.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        eight.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        eight.setFocusable(false);
        eight.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                eightActionPerformed(evt);
            }
        });

        nine.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        nine.setText("9");
        nine.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        nine.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nine.setFocusable(false);
        nine.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                nineActionPerformed(evt);
            }
        });

        add.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        add.setText("+");
        add.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add.setFocusable(false);
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        squared.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        squared.setText("^2");
        squared.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        squared.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        squared.setFocusable(false);
        squared.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                squaredActionPerformed(evt);
            }
        });

        subtract.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        subtract.setText("-");
        subtract.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        subtract.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        subtract.setFocusable(false);
        subtract.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                subtractActionPerformed(evt);
            }
        });

        squareroot.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        squareroot.setText("√");
        squareroot.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        squareroot.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        squareroot.setFocusable(false);
        squareroot.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                squarerootActionPerformed(evt);
            }
        });

        multiply.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        multiply.setText("*");
        multiply.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        multiply.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        multiply.setFocusable(false);
        multiply.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                multiplyActionPerformed(evt);
            }
        });

        cubed.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        cubed.setText("^3");
        cubed.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cubed.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cubed.setFocusable(false);
        cubed.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                cubedActionPerformed(evt);
            }
        });

        divide.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        divide.setText("/");
        divide.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        divide.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        divide.setFocusable(false);
        divide.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                divideActionPerformed(evt);
            }
        });

        cuberoot.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        cuberoot.setText("^(1/3)");
        cuberoot.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cuberoot.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cuberoot.setFocusable(false);
        cuberoot.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                cuberootActionPerformed(evt);
            }
        });

        four.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        four.setText("4");
        four.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        four.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        four.setFocusable(false);
        four.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                fourActionPerformed(evt);
            }
        });

        five.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        five.setText("5");
        five.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        five.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        five.setFocusable(false);
        five.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                fiveActionPerformed(evt);
            }
        });

        six.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        six.setText("6");
        six.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        six.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        six.setFocusable(false);
        six.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                sixActionPerformed(evt);
            }
        });

        one.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        one.setText("1");
        one.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        one.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        one.setFocusable(false);
        one.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                oneActionPerformed(evt);
            }
        });

        two.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        two.setText("2");
        two.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        two.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        two.setFocusable(false);
        two.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                twoActionPerformed(evt);
            }
        });

        three.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        three.setText("3");
        three.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        three.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        three.setFocusable(false);
        three.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                threeActionPerformed(evt);
            }
        });

        negate.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        negate.setText("±");
        negate.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        negate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        negate.setFocusable(false);
        negate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                negateActionPerformed(evt);
            }
        });

        decpoint.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        decpoint.setText(".");
        decpoint.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        decpoint.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        decpoint.setFocusable(false);
        decpoint.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                decpointActionPerformed(evt);
            }
        });

        zero.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        zero.setText("0");
        zero.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        zero.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        zero.setFocusable(false);
        zero.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                zeroActionPerformed(evt);
            }
        });

        buttonGroup1.add(degrees);
        degrees.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        degrees.setSelected(true);
        degrees.setText("Degrees");
        degrees.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        degrees.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        degrees.setFocusable(false);
        degrees.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                degreesActionPerformed(evt);
            }
        });

        buttonGroup1.add(radians);
        radians.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        radians.setText("Radians");
        radians.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        radians.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        radians.setFocusable(false);
        radians.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                radiansActionPerformed(evt);
            }
        });

        equals.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        equals.setText("=");
        equals.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        equals.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        equals.setFocusable(false);
        equals.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                equalsActionPerformed(evt);
            }
        });

        clear.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        clear.setText("CE");
        clear.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        clear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clear.setFocusable(false);
        clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        reset.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        reset.setText("C");
        reset.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        reset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reset.setFocusable(false);
        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        shift.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        shift.setText("Sh");
        shift.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        shift.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        shift.setFocusable(false);
        shift.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                shiftMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(equals, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(divide, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(reset, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(display2)
                    .addComponent(display1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(memoryread, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(memoryclear, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(memorysave, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(degrees)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(radians)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(percent, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(onedividedbyx, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(memorydisplay)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(four, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(five, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(six, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(squareroot, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(subtract, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(one, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(two, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(zero, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(decpoint, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(three, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cubed, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(multiply, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(negate, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cuberoot, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(seven, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(eight, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nine, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(sin, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tan, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(shift, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pi, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(squared, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(display2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(display1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(memorydisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(memoryread, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(memoryclear, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(memorysave, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(onedividedbyx, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(percent, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(degrees)
                            .addComponent(radians))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(sin, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                        .addComponent(tan, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                        .addComponent(pi, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                        .addComponent(shift, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(cos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(seven, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eight, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nine, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(squared, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(subtract, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(squareroot, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(four, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(five, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(six, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(multiply, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cubed, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(one, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(two, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(three, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(divide, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cuberoot, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(negate, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(decpoint, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(zero, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(equals, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    // The Not (!) Statements are to prevent repetetive entry
    private void zeroActionPerformed(ActionEvent evt) {
        if(!zerodisp && !decdisp){
            display1.setText("");
        }
        display1.setText(display1.getText() + "0");
    }

    private void oneActionPerformed(ActionEvent evt) {
        if(!zerodisp && !decdisp){
            display1.setText("");
        }
        display1.setText(display1.getText() + "1");
        zerodisp = true;
    }

    private void twoActionPerformed(ActionEvent evt) {
        if(!zerodisp && !decdisp){
            display1.setText("");
        }
        display1.setText(display1.getText() + "2");
        zerodisp = true;
    }

    private void threeActionPerformed(ActionEvent evt) {
        if(!zerodisp && !decdisp){
            display1.setText("");
        }
        display1.setText(display1.getText() + "3");
        zerodisp = true;
    }

    private void fourActionPerformed(ActionEvent evt) {
        if(!zerodisp && !decdisp){
            display1.setText("");
        }
        display1.setText(display1.getText() + "4");
        zerodisp = true;
    }

    private void fiveActionPerformed(ActionEvent evt) {
        if(!zerodisp && !decdisp){
            display1.setText("");
        }
        display1.setText(display1.getText() + "5");
        zerodisp = true;
    }

    private void sixActionPerformed(ActionEvent evt) {
        if(!zerodisp && !decdisp){
            display1.setText("");
        }
        display1.setText(display1.getText() + "6");
        zerodisp = true;
    }

    private void sevenActionPerformed(ActionEvent evt) {
        if(!zerodisp && !decdisp){
            display1.setText("");
        }
        display1.setText(display1.getText() + "7");
        zerodisp = true;
    }

    private void eightActionPerformed(ActionEvent evt) {
        if(!zerodisp && !decdisp){
            display1.setText("");
        }
        display1.setText(display1.getText() + "8");
        zerodisp = true;
    }

    private void nineActionPerformed(ActionEvent evt) {
        if(!zerodisp && !decdisp){
            display1.setText("");
        }
        display1.setText(display1.getText() + "9");
        zerodisp = true;
    }

    private void decpointActionPerformed(ActionEvent evt) {
        if(!decdisp){
            display1.setText(display1.getText() + ".");
            decdisp = true;
        }
    }

    private void negateActionPerformed(ActionEvent evt) {
        inputB = Double.parseDouble(String.valueOf(display1.getText()));
        doubleOutput = inputB * -1;
        
        if(doubleOutput > min && doubleOutput < max){
            display1.setText(String.valueOf(doubleOutput));
        }
        else{
            display1.setText("Error");
        }
        decdisp = true;
        doubleOutput = 0;
    }

    private void clearActionPerformed(ActionEvent evt) {
        display1.setText("0");
        zerodisp = false;
        decdisp = false;
    }

    private void resetActionPerformed(ActionEvent evt) {
        display1.setText("0");
        display2.setText("");
        zerodisp = false;
        decdisp = false;
        inputA = 0;
        inputB = 0;
        doubleOutput = 0;
    }

    private void memoryreadActionPerformed(ActionEvent evt) {
        display1.setText(String.valueOf(memorydisplay.getText()));
    }

    private void memoryclearActionPerformed(ActionEvent evt) {
        memorydisplay.setText("0");
    }

    private void memorysaveActionPerformed(ActionEvent evt) {
        memorydisplay.setText(String.valueOf(display1.getText()));
    }

    private void onedividedbyxActionPerformed(ActionEvent evt) {
        inputB = Double.parseDouble(String.valueOf(display1.getText()));
        doubleOutput = 1 / inputB;
        
        if(doubleOutput > min && doubleOutput < max){
            display1.setText(String.valueOf(doubleOutput));
        }
        else{
            display1.setText("Error");
        }
        display2.setText("1/" + String.valueOf(inputB));
        doubleOutput = 0;
        intOperationModifier = 0;
    }

    private void piActionPerformed(ActionEvent evt) {
        display1.setText(String.valueOf(Math.PI));
    }

    private void squaredActionPerformed(ActionEvent evt) {
        inputB = Double.parseDouble(String.valueOf(display1.getText()));
        doubleOutput = inputB * inputB;
        
        if(doubleOutput > min && doubleOutput < max){
            display1.setText(String.valueOf(doubleOutput));
        }
        else{
            display1.setText("Error");
        }
        
        display2.setText(String.valueOf(inputB) + "²");
        doubleOutput = 0;
        intOperationModifier = 0;
    }

    private void squarerootActionPerformed(ActionEvent evt) {
        inputB = Double.parseDouble(String.valueOf(display1.getText()));
        doubleOutput = Math.sqrt(inputB);

        display1.setText(String.valueOf(doubleOutput));
        
        display2.setText("√" + String.valueOf(inputB));
        doubleOutput = 0;
        intOperationModifier = 0;
    }

    private void cubedActionPerformed(ActionEvent evt) {
        inputB = Double.parseDouble(String.valueOf(display1.getText()));
        doubleOutput = inputB * inputB * inputB;
        
        if(doubleOutput > min && doubleOutput < max){
            display1.setText(String.valueOf(doubleOutput));
        }
        else{
            display1.setText("Error");
        }
        
        display2.setText(String.valueOf(inputB) + "³");
        doubleOutput = 0;
        intOperationModifier = 0;
    }

    private void cuberootActionPerformed(ActionEvent evt) {
        inputB = Double.parseDouble(String.valueOf(display1.getText()));
        doubleOutput = Math.cbrt(inputB);

        display1.setText(String.valueOf(doubleOutput));
        
        display2.setText("∛" + String.valueOf(inputB));
        doubleOutput = 0;
        intOperationModifier = 0;
    }

    private void shiftMouseClicked(MouseEvent evt) {
        sh = !sh;//{If true --> False}{Else --> True}
    }

    private void sinActionPerformed(ActionEvent evt) {
        inputB = Double.parseDouble(String.valueOf(display1.getText()));
        if(!sh){
            if(!dgrrad){
                display2.setText("sin(" + String.valueOf(inputB) + ")");
                inputB = inputB * oneDegInRad;//0.017... is 1 degree in radians
            }
            doubleOutput = Math.sin(inputB);
        }
        else{
            display2.setText("sinh(" + String.valueOf(inputB) + ")");
            doubleOutput = Math.sinh(inputB);
        }
        
        display1.setText(String.valueOf(doubleOutput));
        doubleOutput = 0;
        intOperationModifier = 0;
    }

    private void cosActionPerformed(ActionEvent evt) {
        inputB = Double.parseDouble(String.valueOf(display1.getText()));
        if(!sh){
            if(!dgrrad){
                display2.setText("cos(" + String.valueOf(inputB) + ")");
                inputB = inputB * oneDegInRad;
            }
            doubleOutput = Math.cos(inputB);
        }
        else{
            display2.setText("cosh(" + String.valueOf(inputB) + ")");
            doubleOutput = Math.cosh(inputB);
        }
        
        display1.setText(String.valueOf(doubleOutput));
        doubleOutput = 0;
        intOperationModifier = 0;
    }

    private void tanActionPerformed(ActionEvent evt) {
        inputB = Double.parseDouble(String.valueOf(display1.getText()));
        if(!sh){
            if(!dgrrad){
                display2.setText("tan(" + String.valueOf(inputB) + ")");
                inputB = inputB * oneDegInRad;
            }
            doubleOutput = Math.tan(inputB);
        }
        else{
            display2.setText("tanh(" + String.valueOf(inputB) + ")");
            doubleOutput = Math.tanh(inputB);
        }
        
        display1.setText(String.valueOf(doubleOutput));
        doubleOutput = 0;
        intOperationModifier = 0;
    }

    private void degreesActionPerformed(ActionEvent evt) {
        dgrrad = false;
    }

    private void radiansActionPerformed(ActionEvent evt) {
        dgrrad = true;
    }

    private void addActionPerformed(ActionEvent evt) {
        if(intOperationModifier == 0){
            inputA = Double.parseDouble(String.valueOf(display1.getText()));
        }
        else{
            inputB = Double.parseDouble(String.valueOf(display1.getText()));
        }
        
        if(intOperationModifier == 1){
            inputA = inputA + inputB;
        }
        
        if(intOperationModifier == 2){
            inputA = inputA - inputB;
        }
        
        if(intOperationModifier == 3){
            inputA = inputA * inputB;
        }
        
        if(intOperationModifier == 4){
            inputA = inputA / inputB;
        }
        
        if(intOperationModifier == 5){
            inputA = inputA * inputB / 100;
        }
        
        display1.setText("0");
        display2.setText(String.valueOf(inputA) + " + ");
        
        intOperationModifier = 1;
        
        decdisp = false;
        zerodisp = false;
    }

    private void subtractActionPerformed(ActionEvent evt) {
        if(intOperationModifier == 0){
            inputA = Double.parseDouble(String.valueOf(display1.getText()));
        }
        else{
            inputB = Double.parseDouble(String.valueOf(display1.getText()));
        }
        
        if(intOperationModifier == 1){
            inputA = inputA + inputB;
        }
        
        if(intOperationModifier == 2){
            inputA = inputA - inputB;
        }
        
        if(intOperationModifier == 3){
            inputA = inputA * inputB;
        }
        
        if(intOperationModifier == 4){
            inputA = inputA / inputB;
        }
        
        if(intOperationModifier == 5){
            inputA = inputA * inputB / 100;
        }
        
        display1.setText("0");
        display2.setText(String.valueOf(inputA) + " - ");
        
        intOperationModifier = 2;
        
        decdisp = false;
        zerodisp = false;
    }

    private void multiplyActionPerformed(ActionEvent evt) {
        if(intOperationModifier == 0){
            inputA = Double.parseDouble(String.valueOf(display1.getText()));
        }
        else{
            inputB = Double.parseDouble(String.valueOf(display1.getText()));
        }
        
        if(intOperationModifier == 1){
            inputA = inputA + inputB;
        }
        
        if(intOperationModifier == 2){
            inputA = inputA - inputB;
        }
        
        if(intOperationModifier == 3){
            inputA = inputA * inputB;
        }
        
        if(intOperationModifier == 4){
            inputA = inputA / inputB;
        }
        
        if(intOperationModifier == 5){
            inputA = inputA * inputB / 100;
        }
        
        display1.setText("0");
        display2.setText(String.valueOf(inputA) + " * ");
        
        intOperationModifier = 3;
        
        decdisp = false;
        zerodisp = false;
    }

    private void divideActionPerformed(ActionEvent evt) {
        if(intOperationModifier == 0){
            inputA = Double.parseDouble(String.valueOf(display1.getText()));
        }
        else{
            inputB = Double.parseDouble(String.valueOf(display1.getText()));
        }
        
        if(intOperationModifier == 1){
            inputA = inputA + inputB;
        }
        
        if(intOperationModifier == 2){
            inputA = inputA - inputB;
        }
        
        if(intOperationModifier == 3){
            inputA = inputA * inputB;
        }
        
        if(intOperationModifier == 4){
            inputA = inputA / inputB;
        }
        
        if(intOperationModifier == 5){
            inputA = inputA * inputB / 100;
        }
        
        display1.setText("0");
        display2.setText(String.valueOf(inputA) + " / ");
        
        intOperationModifier = 4;
        
        decdisp = false;
        zerodisp = false;
    }

    private void percentActionPerformed(ActionEvent evt) {
        inputA = Double.parseDouble(String.valueOf(display1.getText()));
        display1.setText("0");
        display2.setText(String.valueOf(inputA) + "%(");
        
        decdisp = false;
        zerodisp = false;
        intOperationModifier = 5;// Multiply by inputA and divide by 100
    }

    private void equalsActionPerformed(ActionEvent evt) {
        inputB = Double.parseDouble(String.valueOf(display1.getText()));
        
        if(intOperationModifier == 0){
            doubleOutput = inputB;
            display2.setText(String.valueOf(inputB));
        }
        
        if(intOperationModifier == 1){
            doubleOutput = inputA + inputB;
            display2.setText(display2.getText() + String.valueOf(inputB));
        }
        
        if(intOperationModifier == 2){
            doubleOutput = inputA - inputB;
            display2.setText(display2.getText() + String.valueOf(inputB));
        }
        
        if(intOperationModifier == 3){
            doubleOutput = inputA * inputB;
            display2.setText(display2.getText() + String.valueOf(inputB));
        }
        
        if(intOperationModifier == 4){
            doubleOutput = inputA / inputB;
            display2.setText(display2.getText() + String.valueOf(inputB));
        }
        
        if(intOperationModifier == 5){
            doubleOutput = inputA * inputB / 100;
            display2.setText(display2.getText() + String.valueOf(inputB) + ")");
        }
        
        if(doubleOutput > min && doubleOutput < max){
            display1.setText(String.valueOf(doubleOutput));
        }
        else{
            display1.setText("Error");
        }
        
        inputA = 0;
        inputB = 0;
        doubleOutput = 0;
        
        intOperationModifier = 0;
        decdisp = false;
        zerodisp = false;
    }

    public void launchCalculator() {
    	//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Calculator().setVisible(true);
            }
        });
    }
    
    
    public static void main(String args[]) {
    	Calculator test = new Calculator();
    	test.launchCalculator();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton clear;
    private javax.swing.JButton cos;
    private javax.swing.JButton cubed;
    private javax.swing.JButton cuberoot;
    private javax.swing.JButton decpoint;
    private javax.swing.JRadioButton degrees;
    private javax.swing.JTextField display1;
    private javax.swing.JTextField display2;
    private javax.swing.JButton divide;
    private javax.swing.JButton eight;
    private javax.swing.JButton equals;
    private javax.swing.JButton five;
    private javax.swing.JButton four;
    private javax.swing.JButton memoryclear;
    private javax.swing.JTextField memorydisplay;
    private javax.swing.JButton memoryread;
    private javax.swing.JButton memorysave;
    private javax.swing.JButton multiply;
    private javax.swing.JButton negate;
    private javax.swing.JButton nine;
    private javax.swing.JButton one;
    private javax.swing.JButton onedividedbyx;
    private javax.swing.JButton percent;
    private javax.swing.JButton pi;
    private javax.swing.JRadioButton radians;
    private javax.swing.JButton reset;
    private javax.swing.JButton seven;
    private javax.swing.JToggleButton shift;
    private javax.swing.JButton sin;
    private javax.swing.JButton six;
    private javax.swing.JButton squared;
    private javax.swing.JButton squareroot;
    private javax.swing.JButton subtract;
    private javax.swing.JButton tan;
    private javax.swing.JButton three;
    private javax.swing.JButton two;
    private javax.swing.JButton zero;
    // End of variables declaration//GEN-END:variables
}
