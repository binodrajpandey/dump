package com.bebit.gramagent;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * This class is used to return the response as json. This class may not be required. For now it is
 * just the copy from old gram-agent project.
 * 
 * @author binodraj-pandey
 *
 */

public class JsonRet {
  private static final long serialVersionUID = -5710265280671195100L;

  private String usergram = "ug";

  public byte[] toByteArray() {
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    ObjectOutputStream oos;
    try {
      oos = new ObjectOutputStream(bos);
      oos.writeObject(this);
      oos.flush();
      return bos.toByteArray();
    } catch (IOException e) {
      return null;
    }


  }



  public String getUsergram() {
    return usergram;
  }

  public void setUsergram(String usergram) {
    this.usergram = usergram;
  }

  public static long getSerialversionuid() {
    return serialVersionUID;
  }


}
