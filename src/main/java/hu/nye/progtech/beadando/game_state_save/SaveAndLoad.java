package hu.nye.progtech.beadando.game_state_save;

import hu.nye.progtech.beadando.game.Board;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;

public class SaveAndLoad {

    public void save(BoardToSave tabla, String nev) throws JAXBException {
        JAXBContext jbc = JAXBContext.newInstance(BoardToSave.class);
        Marshaller marshaller = jbc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(tabla, new File("src//main//resources//"+nev+".xml"));
    }

    public void load(String nev, Board board) throws JAXBException {
        JAXBContext jbc = JAXBContext.newInstance(BoardToSave.class);
        Unmarshaller unmarshaller = jbc.createUnmarshaller();
        BoardToSave readTabla = (BoardToSave) unmarshaller.unmarshal(new File("src//main//resources//"+nev+".xml"));
        board.setTabla(readTabla.getTabla());
    }
}
