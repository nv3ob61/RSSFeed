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
package org.monmo.java.entities;

import java.io.FileOutputStream;
import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartDocument;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;


/**
 *
 * @author nv3ob61
 */
public class RSSFeedWriter {

  private final String outputFile;
  private final Feed rssfeed;

  public RSSFeedWriter(Feed rssfeed, String outputFile) {
    this.rssfeed = rssfeed;
    this.outputFile = outputFile;
  }

  public void write() throws Exception {

    // create a XMLOutputFactory
    XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();

    // create XMLEventWriter
    XMLEventWriter eventWriter = outputFactory
            .createXMLEventWriter(new FileOutputStream(outputFile));

    // create a EventFactory
    XMLEventFactory eventFactory = XMLEventFactory.newInstance();
    XMLEvent end = eventFactory.createDTD("\n");

    // create and write Start Tag
    StartDocument startDocument = eventFactory.createStartDocument();

    eventWriter.add(startDocument);

    // create open tag
    eventWriter.add(end);

    StartElement rssStart = eventFactory.createStartElement("", "", "rss");
    eventWriter.add(rssStart);
    eventWriter.add(eventFactory.createAttribute("version", "2.0"));
    eventWriter.add(eventFactory.createAttribute("xmlns:atom", "http://www.w3.org/2005/Atom"));
    eventWriter.add(end);
    
    eventWriter.add(eventFactory.createStartElement("", "", "channel"));
    eventWriter.add(end);

    // Write the different nodes
    createNode(eventWriter, "title", rssfeed.getTitle());

    createNode(eventWriter, "link", rssfeed.getLink());

    createNode(eventWriter, "description", rssfeed.getDescription());

    createNode(eventWriter, "language", rssfeed.getLanguage());

    createNode(eventWriter, "copyright", rssfeed.getCopyright());

    createNode(eventWriter, "pubDate", rssfeed.getPubDate());

    for (FeedMessage entry : rssfeed.getMessages()) {
      eventWriter.add(eventFactory.createStartElement("", "", "item"));
      eventWriter.add(end);
      createNode(eventWriter, "title", entry.getTitle());
      createNode(eventWriter, "description", entry.getDescription());
      createNode(eventWriter, "link", entry.getLink());
      createNode(eventWriter, "author", entry.getAuthor());
      createNode(eventWriter, "guid", entry.getGuid());
      eventWriter.add(eventFactory.createEndElement("", "", "item"));
      eventWriter.add(end);
    }

//    eventWriter.add(end);
    eventWriter.add(eventFactory.createEndElement("", "", "channel"));
    eventWriter.add(end);
    eventWriter.add(eventFactory.createEndElement("", "", "rss"));

//    eventWriter.add(end);
    eventWriter.add(eventFactory.createEndDocument());

    eventWriter.close();
  }

  private void createNode(XMLEventWriter eventWriter, String name,
          String value) throws XMLStreamException {
    XMLEventFactory eventFactory = XMLEventFactory.newInstance();
    XMLEvent end = eventFactory.createDTD("\n");
    XMLEvent tab = eventFactory.createDTD("    ");
    // create Start node
    StartElement sElement = eventFactory.createStartElement("", "", name);
    eventWriter.add(tab);
    eventWriter.add(sElement);
    // create Content
    Characters characters = eventFactory.createCharacters(value);
    eventWriter.add(characters);
    // create End node
    EndElement eElement = eventFactory.createEndElement("", "", name);
    eventWriter.add(eElement);
    eventWriter.add(end);
  }
  
  
  private void createStartNode(XMLEventWriter eventWriter, String name,
          String value) throws XMLStreamException {
    XMLEventFactory eventFactory = XMLEventFactory.newInstance();
    XMLEvent end = eventFactory.createDTD("\n");
    XMLEvent tab = eventFactory.createDTD("  ");
    // create Start node
    StartElement sElement = eventFactory.createStartElement("", "", name);
    eventWriter.add(tab);
    eventWriter.add(sElement);
    // create Content
    Characters characters = eventFactory.createCharacters(value);
    eventWriter.add(characters);
    // create End node
    EndElement eElement = eventFactory.createEndElement("", "", name);
    eventWriter.add(eElement);
    eventWriter.add(end);
  }
}
