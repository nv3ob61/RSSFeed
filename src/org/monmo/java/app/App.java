/* 
 * Copyright (C) 2020 nv3ob61
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.monmo.java.app;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import org.monmo.java.entities.Feed;
import org.monmo.java.entities.FeedMessage;
import org.monmo.java.entities.RSSFeedParser;
import org.monmo.java.entities.RSSFeedWriter;
import org.monmo.java.libraries.UtilesEntrada;
import org.monmo.java.libraries.UtilesValidacion;

/**
 *
 * @author mon_mo
 */
public final class App {

  public final void launchApp() {

    String op;

    do {
      muestraBanner();
      op = String.valueOf(UtilesEntrada.SCN.next());
      if (op.matches(UtilesValidacion.REG_OPE)) {
        switch (op) {
          case "read": {
            String link;
            System.out.println();
            System.out.print("Introduzca el enlace: ");
            link = String.valueOf(UtilesEntrada.SCN.next());
            try {
              readFeed(link);
            } catch (Exception e) {
              System.out.println("---");
              System.out.println("ERROR: No se puede leer el enlace");
              System.out.println("---");
            }
          }
          break;
          case "write":
            writeFeed();
            break;
          case "exit":
            System.out.println("Salida normal del programa...");
            break;
        }
      } else {
        System.out.println();
        System.out.println("ERROR: Operación no válida");
      }
    } while (!op.equals("exit"));
  }

//  public static final boolean deseaOtroElemento() {
//    boolean isOk = false;
//    String respuesta;
//    boolean exit = false;
//    do {
//      System.out.println("¿Desea añadir otro elemento? (S / N)");
//      respuesta = UtilesEntrada.SCN.nextLine();
//      if (respuesta.matches(UtilesValidacion.REG_SN)) {
//        if (respuesta.matches(UtilesValidacion.REG_S)) {
//          isOk = true;
//          exit = true;
//        } else {
//          exit = true;
//        }
//      }
//    } while (!exit);
//    return isOk;
//  }

  public static final void muestraBanner() {
    //sout
    System.out.println();
    System.out.println("    RSS Feed");
    System.out.println("-----------------------");
    System.out.printf("Qué operación desea realizar?%n%n"
            + "PARA LEER ...................: read%n"
            + "PARA ESCRIBIR ...............: write%n"
            + "---%n%n");
    System.out.printf("  exit para salir: ");
  }

  public static final void readFeed(String link) {
    RSSFeedParser parser = new RSSFeedParser(link);
    Feed feed = parser.readFeed();
    System.out.println(feed);
    for (FeedMessage message : feed.getMessages()) {
      System.out.println(message);
    }
  }

  public static final void writeFeed() {
    // create the rss feed
    String copyright = "Copyright monmo_2020";
    String title = "RSS Parser / Writer";
    String description = "Small Java project...";
    String language = "en";
    String link = "https://www.testlink.com/";
    Calendar cal = new GregorianCalendar();
    Date creationDate = cal.getTime();
    SimpleDateFormat date_format = new SimpleDateFormat(
            "EEE', 'dd' 'MMM' 'yyyy' 'HH:mm:ss' 'Z", Locale.ENGLISH);
    String pubdate = date_format.format(creationDate);
    Feed rssFeeder = new Feed(title, link, description, language,
            copyright, pubdate);
    // now add one example entry
    FeedMessage feed = new FeedMessage();
    feed.setTitle("RSSFeed");
    feed.setDescription("This is a description");
    feed.setAuthor("emailtest@test.me");
    feed.setGuid("https://www.testlinkprueba1.com");
    feed.setLink("https://www.testlinkprueba2.com");
    rssFeeder.getMessages().add(feed);

    //feed2
    FeedMessage feed2 = new FeedMessage("TITLE",
            "TEST_DESCRIPTION", "https://testlink1.com", "monmo", "https://www.monmo.com");
    rssFeeder.getMessages().add(feed2);

    // now write the file
    RSSFeedWriter writer = new RSSFeedWriter(rssFeeder, "articles.rss");
    try {
      writer.write();
      System.out.println("---");
      System.out.println("Operación completada con éxito");
      System.out.println("---");
    } catch (Exception e) {
    }
  }

}
