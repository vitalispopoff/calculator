package input;

//  @formatter:off
public interface Legs { void A (); }
interface Left extends Legs { void B (); }
interface Rite extends Legs { void C (); }
class Feet { public void A () { } }
class LeftLeg extends Feet implements Left{ @Override public void B () { } }
class RiteLeg extends Feet implements Rite{ @Override public void C () { } }
//  @formatter:on
