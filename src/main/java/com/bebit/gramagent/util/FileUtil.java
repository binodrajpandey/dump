package com.bebit.gramagent.util;

import java.io.File;
import java.io.FileInputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileUtil {
  private static Logger log = LoggerFactory.getLogger(FileUtil.class);

  /**
   * This method will take file name and parse it in to the byte array.
   * 
   * @param filename file name to be read.
   * @return
   */

  public static byte[] getByteArrayFromFile(String filename) {


    File file = new File(filename);

    byte[] byteArray = new byte[(int) file.length()];

    try (FileInputStream fileInputStream = new FileInputStream(file)) {

      fileInputStream.read(byteArray);
    } catch (Exception e) {
      log.error("Could not get byte array from given file name", e);
    }
    return byteArray;
  }
}