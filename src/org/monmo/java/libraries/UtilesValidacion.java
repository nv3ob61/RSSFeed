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
package org.monmo.java.libraries;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author monmo
 */
public class UtilesValidacion {

  public static final String REG_OPE = "read|write|exit";

  public static final String REG_SN = "s|n|S|N";
  public static final String REG_S = "s|S";

  public static final boolean validar(String dato, String er) {
    boolean isOk = false;

    //Proceso de validacion
    try {
      //Compila la expresion regular
      Pattern patron = Pattern.compile(er);

      // Generar el motor de busqueda
      Matcher detector = patron.matcher(dato);

      isOk = detector.matches();

    } catch (Exception e) {
      System.out.println("ERROR: Validacion erronea.");
    }

    return isOk;
  }

}
