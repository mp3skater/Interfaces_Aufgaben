package main.java.net.mp3skater.interfaces.ex5;

public interface MeinIterator
{
	/**
	 * Kontrolliert ob ein n�chstes Element in der Liste vorhanden ist
	 * @return true falls ein n�chstes Element in der Liste vorhanden ist
	 */
	boolean hatNaechstesElement();
	/**
	 * Liefert das n�chste Element in der Liste zur�ck
	 * @return das n�chste Element in der Liste oder null, falls Element nicht
	 * vorhanden ist
	 */
	Object naechstesElement();
	/**
	 * F�gt nach dem Element auf dem Iterator zeigt das �bergebene
	 * Element ein
	 * @param das einzuf�gende Element
	 * @return false wenn das einzuf�gende Element null ist
	 */
	boolean einfuegenElement(Object element);
	/**
	 * Setzt das Element auf welchem momentan der Iterator zeigt, indem es das 
	 * in der Liste vorhandene Element mit dem �bergebenen Element ersetzt. Die
	 * Position des Iterators wird dabei nicht ver�ndert 
	 * @param element das gesetzt werden soll
	 * @return false falls das �bergebene Element null ist, falls die Liste leer ist, 
	 * oder noch nie mit naechstesElement() ein Element angesprungen wurde, oder �ber 
	 * das Listenende hinausgelesen wurde
	 */
	boolean setzenAktuellesElement(java.lang.Object element);
	/**
	 * L�scht das Element, welches momentan das aktuelle Element des Iterators ist. Beim 
	 * L�schen des aktuellen Elementes wird als neues aktuelles Element jenes Element 
	 * genommen, welches nach dem zu l�schenden Element steht. Dabei wird von dieser 
	 * Methode der Iterator so gesetzt, dass der nachfolgende Aufruf von naechstesElement() 
	 * dieses Element zur�ckliefert. 
	 * @return false falls es noch kein aktuelles Element gibt, das gel�scht werden k�nnte
	 */
	boolean loeschenAktuellesElement();
}
