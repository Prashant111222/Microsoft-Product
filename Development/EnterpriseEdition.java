//inheriting the property of MicrosoftProduct class
public class EnterpriseEdition extends MicrosoftProduct
{
    private String clientCompanyName;//encapsulating for limiting the accessing of variable
    private int pricePerUser;
    private int numberOfUser;
    private String activationDate;
    private String licenseExpireDate;
    private boolean isActivated;
    private boolean isExpired;
    
    public EnterpriseEdition(int productNo,String productName,int pricePerUser)
    {
        super(productNo,productName);//calling the constructor from parent class
        this.pricePerUser=pricePerUser;
        clientCompanyName="";
        numberOfUser=0;
        activationDate="";
        licenseExpireDate="";
        isActivated=false;
        isExpired=false;
    }
    
    //creating the accessor method for accessing the private variables in other class
    public String getClientCompanyName()
    {
        return clientCompanyName;
    }
    
    public int getPricePerUser()
    {
        return pricePerUser;
    }
    
    public int getNumberOfUser()
    {
        return numberOfUser;
    }
    
    public String getActivationDate()
    {
        return activationDate;
    }
    
    public String getLicenseExpireDate()
    {
        return licenseExpireDate;
    }
    
    public boolean getIsActivated()
    {
        return isActivated;
    }
    
    public boolean getIsExpired()
    {
        return isExpired;
    }
    
    //declaring the mutator method for setting the value inside the private variable
    public void setPricePerUser(int pricePerUser)
    {
        /*As the value should only be set when the license is activated so
         * selection statement is created below for meeting up the requirment
         */
        if(isActivated==true)
        {
            System.out.println("Oops! Sorry, The price of purchased product cannot be altered.");
        }
        else
        {
            this.pricePerUser=pricePerUser;  
        }
    }
    
    public void productInstallation(String clientCompanyName,int numberOfUser,String activationDate,
                                    String licenseExpireDate,String activationKey)
    {
        //checking the condition, for the license to be activated to set the values through this method
        if(isActivated==true)
        {
            System.out.println("Product has been already Activated!");
            System.out.println("Snippet: Product owned by- "+this.clientCompanyName+"\nActive clients- "+this.numberOfUser);
        }
        else
        {
            this.clientCompanyName=clientCompanyName;
            this.numberOfUser=numberOfUser;
            this.activationDate=activationDate;
            this.licenseExpireDate=licenseExpireDate;
            super.setActivationKey(activationKey);//passing the activation key in the parameter of setter method of parent class
            double grossPrice=numberOfUser*pricePerUser;//gross price is the total price (final price of product)
            super.setPrice(grossPrice);//updating the total price through the setter method from super class
            isActivated=true;
            isExpired=false;
            System.out.println("Congratulations! The license has been successfully activated");
        }    
    }
    
    public void expiringLicense()
    {
        //now for checking the condition to conclude the termination criteria 
        if(isExpired==true)
        {
            System.out.println("The license of the product has been already expired");
        }
        else
        {
            clientCompanyName="";
            activationDate="";
            licenseExpireDate="";
            numberOfUser=0;
            super.setPrice(0);//setting the price value to zero from the super class
            super.setActivationKey("");//setting the empty value for activation key in super class
            isActivated=false;
            isExpired=true;
            System.out.println("Expiration done successfully.");
        }
    }
    
    //method overriding
    @Override
    public void displayDetails()
    {
        super.displayDetails();//calling method from super class to display product number and name(inheritance)
        System.out.println("Payable amount per user: $"+this.pricePerUser);
        
        //checking the validation condition for displaying only if license is activated
        if(isActivated==true)
        {
            System.out.println("Product owned by: "+clientCompanyName);
            System.out.println("Number of active clients: "+numberOfUser);
            System.out.println("Total amount to be paid: $"+super.getPrice());//calling the value from super class
            System.out.println("Date of Installation: "+activationDate);
            System.out.println("License will terminate on: "+licenseExpireDate);
            System.out.println("Activation Code: "+super.getActivationKey());
        }    
        
        //for making validation status to always appear as final statement
        System.out.println("License validation: "+isActivated);
    }

}
