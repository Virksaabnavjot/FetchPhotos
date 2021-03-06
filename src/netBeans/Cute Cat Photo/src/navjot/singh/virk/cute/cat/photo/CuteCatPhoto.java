package navjot.singh.virk.cute.cat.photo;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Navjot Singh Virk Dublin Ireland 11:05 pm, 13th January 2017
 */
public class CuteCatPhoto {

    public static void main(String[] args) throws MalformedURLException, IOException {
        GUI gui = new GUI();
        gui.setVisible(true);

        try {

            URL url = new URL("http://thecatapi.com/api/images/get?format=xml&results_per_page=5");
            //Object o = u.unmarshal( url );
            System.out.println(url);

            //File file = new File("C:\\file.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Response.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Response photo = (Response) jaxbUnmarshaller.unmarshal(url);
            //List<Image> list = photo.getData().getImages().getImageList();
            Image image = photo.getData().getImages().getImage();
            System.out.println("lll" + image.getUrl());
            //System.out.print("nnn" + list.get(0).url);

            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(photo, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}

//Useful resource / References: http://stackoverflow.com/questions/11221136/convert-xml-to-java-object-using-jaxb-unmarshal