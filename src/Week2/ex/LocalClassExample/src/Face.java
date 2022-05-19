
/**
 *
 * @author gdm1
 */
public class Face
{

    private Eye leftEye;
    private Eye rightEye;
    private String mouth;

    public Face(String leftEyeColour, String rightEyeColour)
    {
        this.leftEye = new Eye(leftEyeColour);
        this.rightEye = new Eye(rightEyeColour);
        mouth = "straight";
    }
    
    public void fallAsleep()
    {
        leftEye.isOpen = false;
        rightEye.isOpen = false;
        mouth = "open";
    }
    
    public void frown()
    {
        mouth = "curved down";
    }
    
    public void serious()
    {
        mouth = "straight";
    }
    
    public void smile()
    {
        mouth = "curved up";
    }
    
    public void wakeUp()
    {
        leftEye.isOpen = true;
        rightEye.isOpen = true;
        mouth = "straight";
    }

    @Override
    public String toString()
    {
        return "Left " + leftEye + ", Right " + rightEye + ", and mouth is " + mouth;
    }

    private class Eye
    {

        private final String colour;
        private boolean isOpen;

        public Eye(String colour)
        {
            this.colour = colour;
            this.isOpen = true;
        }

        @Override
        public String toString()
        {
            return "eye is " + colour + " and is " + (isOpen ? "open" : "closed");
        }
    }
}
