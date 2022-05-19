
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author gdm1
 */
public class Crowd
{
    private List<Face> faces = new ArrayList<>();
    
    public void addFace(Face f)
    {
        faces.add(f);
    }
    
    public Iterator crowdIterator()
    {
        class CrowdIterator implements Iterator
        {
            private Face[] facesArray;
            private int nextElement = 0;
            
            public CrowdIterator(List<Face> facesList)
            {
                facesArray = facesList.toArray(new Face[0]);
            }
            
            public boolean hasNext()
            {
                return nextElement < facesArray.length;
            }
            
            public Face next()
            {
                return facesArray[nextElement++];
            }
        }
        
        return new CrowdIterator(faces);
    }
}
