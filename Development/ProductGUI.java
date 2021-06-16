//importing the library
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.BorderLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.Date;
import java.text.SimpleDateFormat;

import java.util.ArrayList;

public class ProductGUI
{   
    //Declaring the variables for different components of GUI
    private static JFrame frame;
    
    private JButton     addProduct,activateProduct,terminateProduct,setProductPrice,displayDetails,btnAdd,
                        btnClear,btnActivate,btnSetPrice,btnTerminate,btnDisplay;
    
    private JLabel      lbProductNo,lbProductName,lbTotalPrice,lbClientCompanyName,lbLicenseActivationDate,
                        lbLicenseExpireDate,lbActivationKey,lbNoOfUser,lbPricePerUser;
                
    private JTextField  productNoFieldAdd,productNoFieldActivate,productNoFieldSetPrice,productNoFieldTerminate,
                        productNoFieldDisplay,productNameField,totalPriceField,clientCompanyNameField,licenseActivationDateField,
                        licenseExpireDateField,activationKeyField,noOfUserField,pricePerUserFieldAdd,pricePerUserFieldSetPrice;
    
    private JPanel      addPane,activatePane,terminatePane,setProductPricePane,displayDetailPane,
                        mainComponentPanel,introPane,copyrightMessagePane;
          
    //Declaring the arraylist of class MicrosoftProduct
    private ArrayList <MicrosoftProduct> detailsList = new ArrayList<MicrosoftProduct>();
    
    //other methods of class ProductGUI are called here
    public ProductGUI(){
        initializeFrame();
        mainComponents();
        introPanel();
        addingProductPanel();
        activatingProductPanel();
        setProductPricePanel();
        terminatingProductPanel();
        displayDetailPanel();
    }
    
    //creating method for developing the main window of GUI
    public void initializeFrame(){
        frame = new JFrame("Microsoft Product");
        frame.setBounds(350,75,600,507);//for making frame appear on the required portion of screen
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
    }
    
    //Following method creates a panel in JFrame to hold buttons which leads to other panel
    public void mainComponents(){
        mainComponentPanel = new JPanel();
        mainComponentPanel.setBounds(0,0,170,507);
        mainComponentPanel.setBackground(Color.BLACK);
        mainComponentPanel.setLayout(new FlowLayout(FlowLayout.LEFT,5,15));//setting the layout for the components inside mainComponentPanel
        frame.add(mainComponentPanel);
        
        addProduct = new JButton("Add Product           ");
        addProduct.setBackground(Color.BLACK);
        addProduct.setForeground(Color.WHITE);
        addProduct.setFont(new Font("Californian FB",Font.BOLD,15));
        mainComponentPanel.add(addProduct);
        //adding event handler for occuring events while clicking the button
        addProduct.addActionListener(new ActionListener(){
            //Overrding the actionPerformed method having parameter ActionEvent of anonymous class ActionListener 
            @Override
            public void actionPerformed(ActionEvent ae){
                addPane.setVisible(true);
                setProductPricePane.setVisible(false);
                terminatePane.setVisible(false);
                activatePane.setVisible(false);
                introPane.setVisible(false);
                displayDetailPane.setVisible(false);
            }
        });
        
        activateProduct = new JButton("Activate Product   ");
        activateProduct.setBackground(Color.BLACK);
        activateProduct.setForeground(Color.WHITE);
        activateProduct.setFont(new Font("Californian FB",Font.BOLD,15));
        mainComponentPanel.add(activateProduct);
        activateProduct.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                activatePane.setVisible(true);
                setProductPricePane.setVisible(false);
                addPane.setVisible(false);
                terminatePane.setVisible(false);
                introPane.setVisible(false);
                displayDetailPane.setVisible(false);
            }
        });
        
        setProductPrice = new JButton("Set Product Price   ");
        setProductPrice.setBackground(Color.BLACK);
        setProductPrice.setForeground(Color.WHITE);
        setProductPrice.setFont(new Font("Californian FB",Font.BOLD,15));
        mainComponentPanel.add(setProductPrice);
        setProductPrice.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                setProductPricePane.setVisible(true);
                addPane.setVisible(false);
                terminatePane.setVisible(false);
                activatePane.setVisible(false);
                introPane.setVisible(false);
                displayDetailPane.setVisible(false);
            }
        });
        
        terminateProduct = new JButton("Terminate Product");
        terminateProduct.setBackground(Color.BLACK);
        terminateProduct.setForeground(Color.WHITE);
        terminateProduct.setFont(new Font("Californian FB",Font.BOLD,15));
        mainComponentPanel.add(terminateProduct);
        terminateProduct.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                terminatePane.setVisible(true);
                setProductPricePane.setVisible(false);
                addPane.setVisible(false);
                activatePane.setVisible(false);
                introPane.setVisible(false);
                displayDetailPane.setVisible(false);
            }
        });
        
        displayDetails = new JButton("Display Details        ");
        displayDetails.setBackground(Color.BLACK);
        displayDetails.setForeground(Color.WHITE);
        displayDetails.setFont(new Font("Californian FB",Font.BOLD,15));
        mainComponentPanel.add(displayDetails);
        displayDetails.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                displayDetailPane.setVisible(true);
                setProductPricePane.setVisible(false);
                addPane.setVisible(false);
                terminatePane.setVisible(false);
                activatePane.setVisible(false);
                introPane.setVisible(false);
            }
        });
        
        //adding the current date and day inside the mainComponentPanel
        Date currentDate = new Date();
        SimpleDateFormat formattingDate = new SimpleDateFormat ("    E dd-MMM-yyyy");
        
        JLabel lbDateTime = new JLabel(formattingDate.format(currentDate));
        lbDateTime.setForeground(Color.CYAN);
        lbDateTime.setFont(new Font("Cambria",Font.BOLD,15));
        mainComponentPanel.add(lbDateTime);
    }
    
    //following method creates the JPanel, and appears only when program runs first time
    public void introPanel(){
        introPane = new JPanel();
        introPane.setBounds(170,0,430,470);
        introPane.setLayout(new BorderLayout());//setting borderlayout in the panel which appear at first glance of GUI
        introPane.setBackground(Color.WHITE);
        frame.add(introPane);
        
        //setting up new panel for adding the introduction message in the main panel
        JPanel smallPane = new JPanel();
        smallPane.setBounds(0,0,430,40);
        introPane.add(smallPane);
        
        //initiating local variable as it is not used in other portion of program
        JLabel welcomeIntro = new JLabel("WELCOME! TO MICROSOFT PRODUCT");
        welcomeIntro.setFont(new Font("Cambria",Font.BOLD,20));
        smallPane.add(welcomeIntro);
        
        //Adding microsoft logo at the middle of the introPanel
        ImageIcon microsoftIcon = new ImageIcon("microsoft-logo.jpg");
        JLabel imageLabel = new JLabel(microsoftIcon);
        introPane.add(imageLabel,BorderLayout.CENTER);
        
        //For adding copyright message at the bottom of the panel
        copyrightMessagePane = new JPanel();
        copyrightMessagePane.setBounds(170,470,430,30);
        copyrightMessagePane.setLayout(new FlowLayout());
        copyrightMessagePane.setBackground(Color.WHITE);
        introPane.add(copyrightMessagePane,BorderLayout.SOUTH);
        
        JLabel copyrightMessage = new JLabel("© 2020 Microsoft All Rights Reserved");
        copyrightMessage.setForeground(Color.BLACK);
        copyrightMessage.setFont(new Font("Baskerville Old Face",Font.BOLD,15));
        copyrightMessagePane.add(copyrightMessage);
    }
    
    //following method creats a panel where components to add products are instantiated
    public void addingProductPanel(){
        addPane = new JPanel();
        addPane.setBounds(170,0,430,500);
        addPane.setLayout(null);
        addPane.setBackground(Color.BLACK);
        frame.add(addPane);
        addPane.setVisible(false);
        
        JLabel addProductLabel = new JLabel("Add Basic Product Info Here!");
        addProductLabel.setBounds(60,15,300,40);
        addProductLabel.setFont(new Font("Book Antiqua",Font.BOLD,20));
        addProductLabel.setForeground(Color.LIGHT_GRAY);
        addPane.add(addProductLabel);
        
        lbProductName = new JLabel("Product Name: ");
        lbProductName.setBounds(10,75,150,30);
        lbProductName.setForeground(Color.WHITE);
        lbProductName.setFont(new Font("Californian FB",Font.BOLD,18));
        addPane.add(lbProductName);
        
        productNameField = new JTextField();
        productNameField.setBounds(200,75,180,25);
        addPane.add(productNameField);
        
        lbProductNo = new JLabel("Product Number: ");
        lbProductNo.setBounds(10,125,150,30);
        lbProductNo.setForeground(Color.WHITE);
        lbProductNo.setFont(new Font("Californian FB",Font.BOLD,18));
        addPane.add(lbProductNo);
        
        productNoFieldAdd = new JTextField();
        productNoFieldAdd.setBounds(200,125,180,25);
        addPane.add(productNoFieldAdd);
        
        lbPricePerUser = new JLabel("Price Per User: ");
        lbPricePerUser.setBounds(10,175,150,30);
        lbPricePerUser.setForeground(Color.WHITE);
        lbPricePerUser.setFont(new Font("Californian FB",Font.BOLD,18));
        addPane.add(lbPricePerUser);
        
        pricePerUserFieldAdd = new JTextField();
        pricePerUserFieldAdd.setBounds(200,175,180,25);
        addPane.add(pricePerUserFieldAdd);
        
        btnAdd = new JButton("Add");
        btnAdd.setBounds(100,230,120,30);
        btnAdd.setBackground(Color.GRAY);
        btnAdd.setForeground(Color.WHITE);
        btnAdd.setFont(new Font("Californian FB",Font.BOLD,18));
        addPane.add(btnAdd);
        //adding event handler so function of adding product will be perd=formed on the click of the button
        btnAdd.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                btnAddFunction();//calling method as it carries functions to be operated
            }
        });
        
        btnClear = new JButton("Clear");
        btnClear.setBounds(260,230,120,30);
        btnClear.setBackground(Color.GRAY);
        btnClear.setForeground(Color.WHITE);
        btnClear.setFont(new Font("Californian FB",Font.BOLD,18));
        addPane.add(btnClear);
        btnClear.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                clearAdd();//calling method to clear the textfields
            }
        });
    }
    
    //following method creats a panel where components to activate products are instantiated
    public void activatingProductPanel(){
        activatePane = new JPanel();
        activatePane.setBounds(170,0,430,500);
        activatePane.setLayout(null);
        activatePane.setBackground(Color.BLACK);
        frame.add(activatePane);
        activatePane.setVisible(false);
        
        JLabel activatingProductLabel = new JLabel("Append Product Description For Activation");
        activatingProductLabel.setBounds(10,15,430,40);
        activatingProductLabel.setFont(new Font("Book Antiqua",Font.BOLD,20));
        activatingProductLabel.setForeground(Color.LIGHT_GRAY);
        activatePane.add(activatingProductLabel);
        
        lbProductNo = new JLabel("Product Number: ");
        lbProductNo.setBounds(10,75,150,30);
        lbProductNo.setForeground(Color.WHITE);
        lbProductNo.setFont(new Font("Californian FB",Font.BOLD,18));
        activatePane.add(lbProductNo);
        
        productNoFieldActivate = new JTextField();
        productNoFieldActivate.setBounds(200,75,180,25);
        activatePane.add(productNoFieldActivate);
        
        lbClientCompanyName = new JLabel("Client Company Name: ");
        lbClientCompanyName.setBounds(10,125,200,30);
        lbClientCompanyName.setForeground(Color.WHITE);
        lbClientCompanyName.setFont(new Font("Californian FB",Font.BOLD,18));
        activatePane.add(lbClientCompanyName);
        
        clientCompanyNameField = new JTextField();
        clientCompanyNameField.setBounds(200,125,180,25);
        activatePane.add(clientCompanyNameField);
        
        lbNoOfUser = new JLabel("User Number: ");
        lbNoOfUser.setBounds(10,175,150,30);
        lbNoOfUser.setForeground(Color.WHITE);
        lbNoOfUser.setFont(new Font("Californian FB",Font.BOLD,18));
        activatePane.add(lbNoOfUser);
        
        noOfUserField = new JTextField();
        noOfUserField.setBounds(200,175,180,25);
        activatePane.add(noOfUserField);
        
        lbLicenseActivationDate = new JLabel("Activation Date: ");
        lbLicenseActivationDate.setBounds(10,225,150,30);
        lbLicenseActivationDate.setForeground(Color.WHITE);
        lbLicenseActivationDate.setFont(new Font("Californian FB",Font.BOLD,18));
        activatePane.add(lbLicenseActivationDate);
        
        licenseActivationDateField = new JTextField();
        licenseActivationDateField.setBounds(200,225,180,25);
        activatePane.add(licenseActivationDateField);
        
        lbLicenseExpireDate = new JLabel("Expiration Date: ");
        lbLicenseExpireDate.setBounds(10,275,150,30);
        lbLicenseExpireDate.setForeground(Color.WHITE);
        lbLicenseExpireDate.setFont(new Font("Californian FB",Font.BOLD,18));
        activatePane.add(lbLicenseExpireDate);
        
        licenseExpireDateField = new JTextField();
        licenseExpireDateField.setBounds(200,275,180,25);
        activatePane.add(licenseExpireDateField);
        
        lbActivationKey = new JLabel("Activation Key: ");
        lbActivationKey.setBounds(10,325,150,30);
        lbActivationKey.setForeground(Color.WHITE);
        lbActivationKey.setFont(new Font("Californian FB",Font.BOLD,18));
        activatePane.add(lbActivationKey);
        
        activationKeyField = new JTextField();
        activationKeyField.setBounds(200,325,180,25);
        activatePane.add(activationKeyField);
        
        lbTotalPrice = new JLabel("Total Price: ");
        lbTotalPrice.setBounds(10,375,150,30);
        lbTotalPrice.setForeground(Color.WHITE);
        lbTotalPrice.setFont(new Font("Californian FB",Font.BOLD,18));
        activatePane.add(lbTotalPrice);
        
        totalPriceField = new JTextField();
        totalPriceField.setBounds(200,375,180,25);
        totalPriceField.setEditable(false);//making field as non-editable
        activatePane.add(totalPriceField);
        
        btnActivate = new JButton("Activate");
        btnActivate.setBounds(100,425,120,30);
        btnActivate.setBackground(Color.GRAY);
        btnActivate.setForeground(Color.WHITE);
        btnActivate.setFont(new Font("Californian FB",Font.BOLD,18));
        activatePane.add(btnActivate);
        btnActivate.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                btnActivateFunction();//calling method to activate product
            }
        });
        
        btnClear = new JButton("Clear");
        btnClear.setBounds(260,425,120,30);
        btnClear.setBackground(Color.GRAY);
        btnClear.setForeground(Color.WHITE);
        btnClear.setFont(new Font("Californian FB",Font.BOLD,18));
        activatePane.add(btnClear);
        btnClear.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                clearActivation();// calling methohd to clear the text fields of activatePane
            }
        });
    }
    
    //following method creats a panel where components to set new price of non activated products are instantiated
    public void setProductPricePanel(){
        setProductPricePane = new JPanel();
        setProductPricePane.setBounds(170,0,430,500);
        setProductPricePane.setLayout(null);
        setProductPricePane.setBackground(Color.BLACK);
        frame.add(setProductPricePane);
        setProductPricePane.setVisible(false);
        
        JLabel setProductPriceLabel = new JLabel("Declare New Price For Product!");
        setProductPriceLabel.setBounds(60,15,300,40);
        setProductPriceLabel.setFont(new Font("Book Antiqua",Font.BOLD,20));
        setProductPriceLabel.setForeground(Color.LIGHT_GRAY);
        setProductPricePane.add(setProductPriceLabel);
        
        lbProductNo = new JLabel("Product Number: ");
        lbProductNo.setBounds(10,75,150,30);
        lbProductNo.setForeground(Color.WHITE);
        lbProductNo.setFont(new Font("Californian FB",Font.BOLD,18));
        setProductPricePane.add(lbProductNo);
        
        productNoFieldSetPrice = new JTextField();
        productNoFieldSetPrice.setBounds(200,75,180,25);
        setProductPricePane.add(productNoFieldSetPrice);
        
        lbPricePerUser = new JLabel("Price Per User: ");
        lbPricePerUser.setBounds(10,125,200,30);
        lbPricePerUser.setForeground(Color.WHITE);
        lbPricePerUser.setFont(new Font("Californian FB",Font.BOLD,18));
        setProductPricePane.add(lbPricePerUser);
        
        pricePerUserFieldSetPrice = new JTextField();
        pricePerUserFieldSetPrice.setBounds(200,125,180,25);
        setProductPricePane.add(pricePerUserFieldSetPrice);
        
        btnSetPrice = new JButton("Set Price");
        btnSetPrice.setBounds(100,180,120,30);
        btnSetPrice.setBackground(Color.GRAY);
        btnSetPrice.setForeground(Color.WHITE);
        btnSetPrice.setFont(new Font("Californian FB",Font.BOLD,18));
        setProductPricePane.add(btnSetPrice);
        btnSetPrice.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                btnSetPricePerUserFunction();// calling method to set the price of non activated product
            }
        });
        
        btnClear = new JButton("Clear");
        btnClear.setBounds(260,180,120,30);
        btnClear.setBackground(Color.GRAY);
        btnClear.setForeground(Color.WHITE);
        btnClear.setFont(new Font("Californian FB",Font.BOLD,18));
        setProductPricePane.add(btnClear);
        btnClear.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                clearSetPricePerUser();//calling method to clear the fields of setProductPricePane
            }
        });
    }
    
    //following method creats a panel where components to terminate products are instantiated
    public void terminatingProductPanel(){
        terminatePane = new JPanel();
        terminatePane.setBounds(170,0,430,500);
        terminatePane.setLayout(null);
        terminatePane.setBackground(Color.BLACK);
        frame.add(terminatePane);
        terminatePane.setVisible(false);
        
        JLabel terminateLabel = new JLabel("Proceed Here! To Terminate License");
        terminateLabel.setBounds(35,15,350,40);
        terminateLabel.setFont(new Font("Book Antiqua",Font.BOLD,20));
        terminateLabel.setForeground(Color.LIGHT_GRAY);
        terminatePane.add(terminateLabel);
        
        lbProductNo = new JLabel("Product Number: ");
        lbProductNo.setBounds(10,75,150,30);
        lbProductNo.setForeground(Color.WHITE);
        lbProductNo.setFont(new Font("Californian FB",Font.BOLD,18));
        terminatePane.add(lbProductNo);
        
        productNoFieldTerminate = new JTextField();
        productNoFieldTerminate.setBounds(200,75,180,25);
        terminatePane.add(productNoFieldTerminate);
        
        btnTerminate = new JButton("Terminate");
        btnTerminate.setBounds(100,130,120,30);
        btnTerminate.setBackground(Color.GRAY);
        btnTerminate.setForeground(Color.WHITE);
        btnTerminate.setFont(new Font("Californian FB",Font.BOLD,18));
        terminatePane.add(btnTerminate);
        btnTerminate.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                btnTerminateFunction();// calling method to terminate the license of the product
            }
        });
        
        btnClear = new JButton("Clear");
        btnClear.setBounds(260,130,120,30);
        btnClear.setBackground(Color.GRAY);
        btnClear.setForeground(Color.WHITE);
        btnClear.setFont(new Font("Californian FB",Font.BOLD,18));
        terminatePane.add(btnClear);
        btnClear.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                productNoFieldTerminate.setText(null);// clearing the fields 
            }
        });
    }
     
    //following method creats a panel where components to display product details are instantiated
    public void displayDetailPanel(){
        displayDetailPane = new JPanel();
        displayDetailPane.setBounds(170,0,430,500);
        displayDetailPane.setLayout(null);
        displayDetailPane.setBackground(Color.BLACK);
        frame.add(displayDetailPane);
        displayDetailPane.setVisible(false);
        
        JLabel displayDetailLabel = new JLabel("Invoke Product Details Through Number");
        displayDetailLabel.setBounds(15,15,400,40);
        displayDetailLabel.setFont(new Font("Book Antiqua",Font.BOLD,20));
        displayDetailLabel.setForeground(Color.LIGHT_GRAY);
        displayDetailPane.add(displayDetailLabel);
        
        lbProductNo = new JLabel("Product Number: ");
        lbProductNo.setBounds(10,75,150,30);
        lbProductNo.setForeground(Color.WHITE);
        lbProductNo.setFont(new Font("Californian FB",Font.BOLD,18));
        displayDetailPane.add(lbProductNo);
        
        productNoFieldDisplay = new JTextField();
        productNoFieldDisplay.setBounds(200,75,180,25);
        displayDetailPane.add(productNoFieldDisplay);
        
        btnDisplay = new JButton("Display");
        btnDisplay.setBounds(100,130,120,30);
        btnDisplay.setBackground(Color.GRAY);
        btnDisplay.setForeground(Color.WHITE);
        btnDisplay.setFont(new Font("Californian FB",Font.BOLD,18));
        displayDetailPane.add(btnDisplay);
        btnDisplay.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                btnDisplayFunction();// calling method to display the details of inserted products
            }
        });
        
        btnClear = new JButton("Clear");
        btnClear.setBounds(260,130,120,30);
        btnClear.setBackground(Color.GRAY);
        btnClear.setForeground(Color.WHITE);
        btnClear.setFont(new Font("Californian FB",Font.BOLD,18));
        displayDetailPane.add(btnClear);
        btnClear.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                productNoFieldDisplay.setText(null);//making the field empty
            }
        });
    }

    //creating method to add the product while clicking the add button
    public void btnAddFunction(){
        //declaring variables for storing the inputs from GUI
        String nameOfProduct = productNameField.getText();
        int numberOfProduct = 0;
        int priceOfProduct = 0;
        
        //using try-catch block to throw the exceptions inorder to prevent crashing of program from invalid input
        try{
            numberOfProduct = Integer.parseInt(productNoFieldAdd.getText());//converting the input string to integer using wrapper class
            priceOfProduct = Integer.parseInt(pricePerUserFieldAdd.getText());
        }
        catch(NumberFormatException nfe){
            //For showing the conclusion in the JOptionPane
            JOptionPane.showMessageDialog(frame,"Please! Check for Empty Fields & Values Before Adding Product","Error-404",0);
            return;
        }
        
        if (nameOfProduct.equals("") || numberOfProduct==0 || priceOfProduct==0){
            JOptionPane.showMessageDialog(frame,"Please! Check for Empty Fields & Values Before Adding Product","Error-404",0);
            return;
        }else if(priceOfProduct<0){
            JOptionPane.showMessageDialog(frame,"Please! Provide Positive Value for Price of Product","Error-404",0);
            return;
        }
        
        //using for-each loop to iterate throug the arraylist
        for (MicrosoftProduct microsoftObj: detailsList){
            //checking wether microsoftObj is an object of EnterpriseEdition too
            if(microsoftObj instanceof EnterpriseEdition){
                /*Class casting the object of child class i.e EnterpriseEdition with respect to the parent class i.e MecrosoftProduct
                 *So that, all the methods and variables of both child and parents class can be accessible using objects of parents class 
                 */
                EnterpriseEdition enterpriseObj = (EnterpriseEdition) microsoftObj;
                
                //checking whether the product number and the input product number from the arraylist are similar or not
                if(numberOfProduct==enterpriseObj.getProductNo()){
                    JOptionPane.showMessageDialog(frame,"Oops! Submitted Product Already Exist!","Warning",2);
                    return;
                }
            }
        }
        /*adding the inputs from GUI in the arraylist by calling the constructor of the EnterpriseEdition
         *When the above statements does not return method then only the following conditions are executed
         */ 
        detailsList.add(new EnterpriseEdition(numberOfProduct,nameOfProduct,priceOfProduct));
        JOptionPane.showMessageDialog(frame,"Congratulations! New Product has Successfully Added","Execution",1);
        return;
    }
    
    // creating method to clear the text fields of addPane
    public void clearAdd(){
        productNameField.setText(null);
        productNoFieldAdd.setText(null);
        pricePerUserFieldAdd.setText(null);
    }
    
    //creating method to activate the product while clicking activate button
    public void btnActivateFunction(){
        int numberOfProduct = 0;
        String nameOfCompany = clientCompanyNameField.getText();
        int numberOfUsers = 0;
        String dateOfActivation = licenseActivationDateField.getText();
        String dateOfExpiry = licenseExpireDateField.getText();
        String activationKey = activationKeyField.getText();
        
        try{
            numberOfProduct = Integer.parseInt(productNoFieldActivate.getText());
            numberOfUsers = Integer.parseInt(noOfUserField.getText());
        }
        catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(frame,"Please! Check for Empty Fields & Values Before Activating Product","Error-404",0);
            return;
        }
        
        if (numberOfProduct==0 || nameOfCompany.equals("") || numberOfUsers==0 || dateOfActivation.equals("") || dateOfExpiry.equals("") || activationKey.equals("")){
            JOptionPane.showMessageDialog(frame,"Please! Check for Empty Fields & Values Before Activating Product","Error-404",0);
            return;
        }else if(numberOfUsers<0){
            JOptionPane.showMessageDialog(frame,"Please! Provide Positive Value for User Number","Error-404",0);
            return;
        }
        
        for (MicrosoftProduct microsoftObj: detailsList){
            if (microsoftObj instanceof EnterpriseEdition){
                EnterpriseEdition enterpriseObj = (EnterpriseEdition) microsoftObj;
                
                //checking whether the given productNo exist in list and also is not activated for performing activation operation
                if(numberOfProduct==enterpriseObj.getProductNo() && enterpriseObj.getIsActivated()==false){
                    enterpriseObj.productInstallation(nameOfCompany,numberOfUsers,dateOfActivation,dateOfExpiry,activationKey);
                    totalPriceField.setText("$"+String.valueOf(enterpriseObj.getPrice()));//converting boolean to String for executing it in text field of total price
                    JOptionPane.showMessageDialog(frame,"Congratulations! Product has Successfully Activated","Execution",1);
                    return;
                }
                else if(numberOfProduct==enterpriseObj.getProductNo() && enterpriseObj.getIsActivated()==true){
                    String details = "Oops! Product Already Exist" + "\nSnippet:\nProduct Owner- "+enterpriseObj.getClientCompanyName() + 
                                     "\nNumber of Users- "+enterpriseObj.getNumberOfUser();
                    JOptionPane.showMessageDialog(frame,details,"Warning",2);
                    return;
                }
            }
        }
        
        //Following JOptionPane is only executed if above conditions are not returned
        JOptionPane.showMessageDialog(frame,"Oops! Entered Product Doesn't Exist to Activate!","Warning",2);
        return;
    }
    
    // creating method to clear the fields of activatePane
    public void clearActivation(){
        productNoFieldActivate.setText(null);
        clientCompanyNameField.setText(null);
        noOfUserField.setText(null);
        licenseActivationDateField.setText(null);
        licenseExpireDateField.setText(null);
        activationKeyField.setText(null);
        totalPriceField.setText(null);
    }
    
    //creating method to set price of non activate product while clicking set price button
    public void btnSetPricePerUserFunction(){
        int productNumber = 0;
        int pricePerUser = 0;
        
        try{
            productNumber = Integer.parseInt(productNoFieldSetPrice.getText());
            pricePerUser = Integer.parseInt(pricePerUserFieldSetPrice.getText());
        }
        catch(NumberFormatException nef){
            JOptionPane.showMessageDialog(frame,"Please! Check for Empty Fields & Values Before Altering Price","Error-404",0);
            return;
        }
        
        if (productNumber == 0 || pricePerUser == 0){
            JOptionPane.showMessageDialog(frame,"Please! Check for Empty Fields & Values Before Altering Price","Error-404",0);
            return;
        }else if(pricePerUser<0){
            JOptionPane.showMessageDialog(frame,"Please! Provide Positive Value for Price of Product","Error-404",0);
            return;
        }
        
        for (MicrosoftProduct microsoftObj: detailsList){
            if (microsoftObj instanceof EnterpriseEdition){
                EnterpriseEdition enterpriseObj = (EnterpriseEdition) microsoftObj;
                if(productNumber==enterpriseObj.getProductNo() && enterpriseObj.getIsActivated()==false){
                    enterpriseObj.setPricePerUser(pricePerUser);
                    JOptionPane.showMessageDialog(frame,"Congratulations! Product Price has Successfully Altered!","Execution",1);
                    return;
                }
                else if (productNumber==enterpriseObj.getProductNo() && enterpriseObj.getIsActivated()==true){
                    JOptionPane.showMessageDialog(frame,"Oops! Price of Activated Product can not be Altered!","Warning",2);
                    return;
                }
            }
        }
        
        JOptionPane.showMessageDialog(frame,"Oops! Entered Product Doesn't Exist to Alter Price!","Warning",2);
        return;
    }
    
    // creating method to empty all the fields ofo setPricePane
    public void clearSetPricePerUser(){
        productNoFieldSetPrice.setText(null);
        pricePerUserFieldSetPrice.setText(null);
    }
    
    // creating method to termiante the licese while clicking the terminate button
    public void btnTerminateFunction(){
        int productNumber = 0;
        
        try{
            productNumber = Integer.parseInt(productNoFieldTerminate.getText());
        }
        catch(NumberFormatException nef){
            JOptionPane.showMessageDialog(frame,"Please! Check for Empty Fields & Values Before Terminating Product","Error-404",0);
            return;
        }
        
        if (productNumber == 0){
            JOptionPane.showMessageDialog(frame,"Please! Check for Empty Fields & Values Before Terminating Product","Error-404",0);
            return;
        }
        
        for (MicrosoftProduct microsoftObj: detailsList){
            if (microsoftObj instanceof EnterpriseEdition){
                EnterpriseEdition enterpriseObj = (EnterpriseEdition) microsoftObj;
                if(productNumber==enterpriseObj.getProductNo() && enterpriseObj.getIsActivated()==true){
                    enterpriseObj.expiringLicense();
                    JOptionPane.showMessageDialog(frame,"Congratulations! Expiration of Product has Done Successfully","Execution",1);
                    return;
                }
                else if (productNumber==enterpriseObj.getProductNo() && enterpriseObj.getIsActivated()==false){
                    JOptionPane.showMessageDialog(frame,"Oops! Product is not Activated Yet!","Warning",2);
                    return;
                }
            }
        }
        
        JOptionPane.showMessageDialog(frame,"Oops! Entered Product Doesn't Exist to Termiante!","Warning",2);
        return;
    }
    
    //creating method to display the details of the product while clicking the Dispaly button
    public void btnDisplayFunction(){
        int productNumber = 0;
        
        try{
            productNumber = Integer.parseInt(productNoFieldDisplay.getText());
        }
        catch(NumberFormatException nef){
            JOptionPane.showMessageDialog(frame,"Please! Check for Empty Fields & Values Before Displaying Details","Error-404",0);
            return;
        }
        
        if (productNumber == 0){
            JOptionPane.showMessageDialog(frame,"Please! Check for Empty Fields & Values Before Displaying Details","Error-404",0);
            return;
        }
        
        for (MicrosoftProduct microsoftObj: detailsList){
            if (microsoftObj instanceof EnterpriseEdition){
                EnterpriseEdition enterpriseObj = (EnterpriseEdition) microsoftObj;
                if(productNumber==enterpriseObj.getProductNo()){
                    JOptionPane.showMessageDialog(frame,"You are About to Witness the Details in Terminal !","Execution",1);
                    enterpriseObj.displayDetails();
                    return;
                }
            }
        }
        
        JOptionPane.showMessageDialog(frame,"Oops! Entered Product Doesn't Exist to Display Details!","Warning",2);
        return;
    }
    
    public static void main(String [] args){
        new ProductGUI().frame.setVisible(true);//setting the visibility of main JFrame
    }
}
