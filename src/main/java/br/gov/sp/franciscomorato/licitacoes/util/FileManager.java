
package br.gov.sp.franciscomorato.licitacoes.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * Classe para configurar a manutenção dos arquivos enviados via multipart
 * @author thiago
 */
@Component
public class FileManager 
{
    @Value("${manager.file.path}")
    private String basePath;

    public String save(String folderPath,MultipartFile file)
    {
        String fullPath = basePath + folderPath+"/"+ generateRandomNumber()+"."+getFileExtension(file);

        try
        {
          if (Objects.nonNull(file) && !file.isEmpty() && file.getSize() > 0)
          {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(fullPath);
            Files.write(path, bytes);
          } else
          {
            fullPath = null;
          }
        } catch (IllegalStateException | IOException e)
        {
          fullPath = null;
        }
        return fullPath;
    }

    private static String generateRandomNumber()
    {
        int aNumber = 0; 
        aNumber = (int)((Math.random() * 9000000)+1000000); 
        return String.valueOf(aNumber);
    }

    private String getFileExtension(MultipartFile file) 
    {
        String name = file.getOriginalFilename();
        try {
            return name.substring(name.lastIndexOf(".") + 1);
        } catch (Exception e) {
            return "";
        }
    }

    public String remove(String folderPath,String file)
    {
        String fullPath = basePath + folderPath+"/"+file;

        try
        {
          File fileRemove = new File(fullPath);
          fileRemove.delete();
        } catch (IllegalStateException e)
        {
          fullPath = null;
        }
        return fullPath;
    }
}
