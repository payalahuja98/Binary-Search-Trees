public class LLNode<T> 
{
  private LLNode link;
  private T info;
  
  public LLNode(T info)
  {
    this.info = info;
    link = null;
  }
 
  public void setInfo(T info)
  {
    this.info = info;
  }

  public T getInfo()
  {
    return info;
  }
  
  public void setLink(LLNode link)
  {
    this.link = link;
  }

  public LLNode getLink()
  {
    return link;
  }
} 


     
  
