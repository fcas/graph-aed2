package heap;

/**
* Interface para um elemento num conjunto dinamico. Pode-se recuperar
* e modificar uma chave que eh um objeto Comparable e comparamos
* os elementos do tipo ElementoDinamico com outros do mesmo tipo.
* 
* @author AnderShow
*/

public interface ElementoDinamico extends Comparable {
   /**
    * Modifica a chave de um elemento
    *
    * @param key Chave a ser colocada.
    */
   public void setChave(Comparable key);

   /**
    * Retorna a chave de um dado elemento.
    */
   public Comparable getChave();

   /**
    * Compara o ElementoDinamico a outro objeto comparavel.
    * 
    * The normal implementation is simply <code>return
    * ElementoDinamico.Helper.compareTo(this, e);</code>
    *
    * @param e O outro objeto.
    * @return Um inteiro negativo se (this) for menor que 'e'.
    * 	0 se forem iguais e um positivo se (this) for maior.
    * @throws ClassCastException se a implementacao chama
    * ElementoDinamico.Helper.compareTo(this, e) e 'e' nao implementa Comparable.
    */
   public int compareTo(Object e);

   /** Classe interna para definir metodos estaticos de auxilio.*/
   public static class Helper  {
	/**
	 * Compara um ElementoDinamico a outro objeto.
	 * Se o outro objeto tambem for ElementoDinamico, 
	 * a chave de ambos eh comparada. Se o outro objeto
	 * nao eh do tipo ElementoDinamico, mas eh Comparable,
	 * entao a chave desse objeto sera usada para comparar.
	 * Se o outro objeto nao for Comparable, excecao ClassCastException eh lancada.
	 *
	 * @param e O ElementoDinamico.
	 * @param o O outro objeto.
	 * @return negativo se o ElementoDinamico for menor, 0 para igual, 1 para maior.
	 * @throws ClassCastException se o objeto o nao for Comparable.
	 */
	public static int compareTo(ElementoDinamico e, Object o) {
	    if (o instanceof ElementoDinamico)
		return e.getChave().compareTo(((ElementoDinamico) o).getChave());
	    else if (o instanceof Comparable)
		return e.getChave().compareTo(o);
	    else
		throw new ClassCastException("Tentativa de comparar um ElementoDinamico a um objeto que nao implementa Comparable.");
	}

	/**
	 * Realiza o cast de um objeto para ElementoDinamico, lancando
	 * um ClassCastException se o objeto recebido nao implementar a interface do ElementoDinamico.
	 *
	 * @param o O objeto.
	 * @return O mesmo objeto, mas lancado como ElementoDinamico.
	 * @throws ClassCastException se 'o' nao implementa a interface ElementoDinamico corretamente.
	 */
	public static ElementoDinamico cast(Object o) {
	    if (o instanceof ElementoDinamico)
		return (ElementoDinamico) o;
	    else
		throw new ClassCastException("Objeto nao obedece a interface do ElementoDinamico.");
	}
   }
}