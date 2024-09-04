package Controller;

public class RatingController 
{
    public static void addRating(int ratingValue) 
    {
        // Validate rating value
        if (ratingValue < 1 || ratingValue > 5) {
            System.out.println("Invalid rating value. Please enter a value between 1 and 5.");
            return;
        }
        else{
            System.out.println("-------------");
            if(ratingValue==1){
                System.out.println(" * ");
                System.out.println("1-Poor");
            }
            else if(ratingValue==2){
                System.out.println(" * * ");
                System.out.println("2-Moderate");
            }
            else if(ratingValue==3){
                System.out.println(" * * * ");
                System.out.println("3-Good");
            }
            else if(ratingValue==4){
                System.out.println(" * * * *");
                System.out.println("4-Very Good");
            }
            else{
                System.out.println(" * * * * *");
                System.out.println("5-Excellent");
            }
            System.out.println("-------------");
            System.out.println("Thank you for Rating us!");
            // System.out.println("-----------------------------");
        }
    }
    
}
