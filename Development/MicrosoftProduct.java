/**
 * @author Prashant Nepal
 * @version (05.2020)
 */
public class MicrosoftProduct
{
    private int productNo;//Data hiding method
    private String productName;
    private String activationKey;
    private double price;

    public MicrosoftProduct(int productNo,String productName)
    {
        this.productNo=productNo;//refering the variable as the instance variable
        this.productName=productName;
        activationKey="";
        price=0.0d;
    }
    
    //creating the accessor method for accessing the feature of private variable in other classes
    public int getProductNo()
    {
        return productNo;
    }
    
    public String getProductName()
    {
        return productName;
    }
    
    public String getActivationKey()
    {
        return activationKey;
    }
    
    public double getPrice()
    {
        return price;
    }
    
    //initializing the mutator method for setting value in the private variables
    public void setProductName(String productName){
        this.productName=productName;
    }
    
    public void setProductNo(int productNo){
        this.productNo=productNo;
    }
    
    public void setActivationKey(String activationKey)
    {
        this.activationKey=activationKey;
    }
    
    public void setPrice(double price)
    {
        this.price=price;
    }
    
    public void displayDetails()
    {
        System.out.println("Product No.: "+productNo);
        System.out.println("Product name: "+productName);
        
        //creating selection statement so that the ouput is given only if condition is satisfied
        if (!activationKey.equals(""))
        {
            System.out.println("Activation Key for your subscription: " +activationKey);
        }
        if (price != 0)
        {
            System.out.println("Payable Amount: $" +price);
        }
    }
    
}
