package cscd350.ayic.triviamaze;

import java.util.Random;

import cscd350.ayic.utility.DataBase;

public class TrueFalseBehavior implements QuestionBehavior
{
	private DataBase _db;
	private int _id;
	private boolean _bluffing;

	public TrueFalseBehavior(int id)
	{
		_db = DataBase.getInstance();
		_id = id;
	}

	@Override
	public String getQuestion()
	{
		Random r = new Random();
		int falseId = DataBase.getInstance().randomAID(false);
		_bluffing = r.nextBoolean();
		if (_bluffing == false)
		{
			return "Is this " + _db.retrieveA(_id) + "?";
		}
		else
		{
			return "Is this " + _db.retrieveA(falseId) + "?";
		}
	}

	@Override
	public String getCorrectAnswer()
	{
		return !_bluffing + "";
	}

	@Override
	public String[] getFakeAnswers()
	{
		String[] fake = new String[1];
		fake[0] = _bluffing + "";
		return fake;
	}

}
