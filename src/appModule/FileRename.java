package appModule;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Arrays;
import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.commons.io.filefilter.WildcardFileFilter;

public class FileRename {
 
 public static void renameX(String sDirectory, String sOrigFileExt, String sNewFileName) throws IOException {
//"C://Users//mradford//Downloads"
//"crdownload"
	 
  FileRename fr= new FileRename();
//  File newfile = fr.getTheNewestFile(sDirectory, sOrigFileExt);
  File newfile = fr.getTheNewestFile(sDirectory, sOrigFileExt);
  newfile.renameTo(new File(sDirectory + sNewFileName));
  String filename= newfile.getName();
 
  System.out.println("latest file is= "+filename);
  
  if (newfile.delete()) {
	  
  }
  
 }
 public File getTheNewestFile(String filePath, String ext) {
     File theNewestFile = null;
     File dir = new File(filePath);
     FileFilter fileFilter = new WildcardFileFilter("*." + ext);
     File[] files = dir.listFiles(fileFilter);

     if (files.length > 0) {
         /** The newest file comes first **/
         Arrays.sort(files, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
         theNewestFile = files[0];
     }

     return theNewestFile;
 }
}
  
    