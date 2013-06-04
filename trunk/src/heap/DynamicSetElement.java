package heap;

/**
* Interface para um elemento num conjunto dinamico. Pode-se recuperar
* e modificar uma chave que eh um objeto Comparable e comparamos
* os elementos do tipo DynamicSet com outros do mesmo tipo.
*/

public interface DynamicSetElement extends Comparable
{
   /**
    * Modifica a chave de um elemento
    *
    * @param key Chave a ser colocada.
    */
   public void setKey(Comparable key);

   /**
    * Retorna a chave de um dado elemento.
    */
   public Comparable getKey();

   /**
    * Compara o DynamicSetElement a outro objeto comparavel.
    * 
    * The normal implementation is simply <code>return
    * DynamicSetElement.Helper.compareTo(this, e);</code>
    *
    * @param e O outro objeto.
    * @return Um inteiro negativo se (this) for menor que 'e'.
    * 	0 se forem iguais e um positivo se (this) for maior.
    * @throws ClassCastException se a implementacao chama
    * DynamicSetElement.Helper.compareTo(this, e) e 'e' nao implementa Comparable.
    */
   public int compareTo(Object e);

   /** Classe interna para definir metodos estaticos de auxilio.*/
   public static class Helper
   {
	/**
	 * Compara um DynamicSetElement a outro objeto.
	 * Se o outro objeto tambem for DynamicSetElement, 
	 * a chave de ambos eh comparada. Se o outro objeto
	 * nao eh do tipo DynamicSetElement, mas eh Comparable,
	 * entao a chave desse objeto sera usada para comparar.
	 * Se o outro objeto nao for Comparable, excecao ClassCastException eh lancada.
	 *
	 * @param e O DynamicSetElement.
	 * @param o O outro objeto.
	 * @return negativo se o DynamicSetElement for menor, 0 para igual, 1 para maior.
	 * @throws ClassCastException se o objeto o nao for Comparable.
	 */
	public static int compareTo(DynamicSetElement e, Object o)
	{
	    if (o instanceof DynamicSetElement)
		return e.getKey().compareTo(((DynamicSetElement) o).getKey());
	    else if (o instanceof Comparable)
		return e.getKey().compareTo(o);
	    else
		throw new ClassCastException("Tentativa de comparar um DynamicSetElement a um objeto que nao implementa Comparable.");
	}

	/**
	 * Realiza o cast de um objeto para DynamicSetElement, lancando
	 * um ClassCastException se o objeto recebido nao implementar a interface do DynamicSetElement.
	 *
	 * @param o O objeto.
	 * @return O mesmo objeto, mas lancado como DynamicSetElement.
	 * @throws ClassCastException se 'o' nao implementa a interface DynamicSetElement corretamente.
	 */
	public static DynamicSetElement cast(Object o)
	{
	    if (o instanceof DynamicSetElement)
		return (DynamicSetElement) o;
	    else
		throw new ClassCastException("Object fails to implement DynamicSetElement interface.");
	}
   }
}