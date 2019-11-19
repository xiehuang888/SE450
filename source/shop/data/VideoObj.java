package shop.data;

/**
 * Implementation of Video interface.
 * @see Data
 */
final class VideoObj implements Video {
  private final String _title;
  private final int    _year;
  private final String _director;

  /**
   * Initialize all object attributes.
   * Title and director are "trimmed" to remove leading and final space.
   * @throws IllegalArgumentException if object invariant violated.
   */
  VideoObj(String title, int year, String director) {
    _title = title;
    _director = director;
    _year = year;
  }

  public String director() {
    // TODO  
    return this._director;
  }

  public String title() {
    // TODO  
    return this._title;
  }

  public int year() {
    // TODO  
    return this._year;
  }

  public boolean equals(Object thatObject) {
    // TODO  
    if(this == thatObject){
      return true;
    }
    if(!(thatObject instanceof VideoObj))
      return false;

    VideoObj that= (VideoObj)thatObject;
    return _director.equals(((VideoObj) thatObject)._director)
            &&_year == (that._year)
            &&_title.equals(((VideoObj) thatObject)._title);
  }

  public int hashCode() {
    // TODO  
    int result = 17;
    result = 37*result + _title.hashCode();
    result = 37*result + (int)_year;
    result = 37*result + _director.hashCode();
    return result;
  }

  public int compareTo(Object thatObject) {
    // TODO  
    if(thatObject.equals(null))
      throw new NullPointerException();
    if(!(thatObject instanceof VideoObj)){
      throw new ClassCastException("incompatible type");
    }
    VideoObj that = (VideoObj) thatObject;

    int title = _title.compareTo(that._title);
    if( title != 0) return title;
    if (_year < that._year)
      return -1;
    if (_year > that._year)
      return 1;
    int director = _director.compareTo(that._director);
    if (director != 0) return director;

    return 0;
  }

  public String toString() {
    // TODO  
    return this._title + " ("+this._year+")"+" : "+this._director;
  }
}
