package mk.iwec.schedulerapplication.service;

import mk.iwec.schedulerapplication.model.Image;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {



        public Image uploadImage(MultipartFile file) ;


        public Image getInfoByImageByName(String name) ;

        public byte[] getImage(String name) ;



}
