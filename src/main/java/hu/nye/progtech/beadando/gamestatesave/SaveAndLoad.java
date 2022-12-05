package hu.nye.progtech.beadando.gamestatesave;

import java.io.File;

import hu.nye.progtech.beadando.game.Board;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

/**
 * Mentest csinal es mentest tolt be.
 */
public class SaveAndLoad {

    /**
     * Mentes.
     */
    public void save(BoardToSave tabla, String nev) throws JAXBException {
        JAXBContext jbc = JAXBContext.newInstance(BoardToSave.class);
        Marshaller marshaller = jbc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(tabla, new File("src//main//resources//" + nev + ".xml"));
    }

    /**
     * Betoltes.
     */
    public void load(String nev, Board board) throws JAXBException {
        JAXBContext jbc = JAXBContext.newInstance(BoardToSave.class);
        Unmarshaller unmarshaller = jbc.createUnmarshaller();
        BoardToSave readTabla = (BoardToSave) unmarshaller.unmarshal(new File("src//main//resources//" + nev + ".xml"));
        board.setTabla(readTabla.getTabla());
    }
}
