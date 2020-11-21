package sheridan.zammichr.progfinalproj

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.animation.AnimationUtils
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var isOpen = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val fabOpen = AnimationUtils.loadAnimation(this, R.anim.fab_open)
        val fabClose = AnimationUtils.loadAnimation(this, R.anim.fab_close)
        val fabRClockwise = AnimationUtils.loadAnimation(this, R.anim.rotate_clockwise)
        val fabRCClockwise = AnimationUtils.loadAnimation(this, R.anim.rotate_counterclockwise)

        fab.setOnClickListener{
            if (isOpen) {
                fabHike.startAnimation(fabClose)
                fabBike.startAnimation(fabClose)
                fabSwim.startAnimation(fabClose)
                fab.startAnimation(fabRClockwise)

                isOpen = false
            }
            else {
                fabHike.startAnimation(fabOpen)
                fabBike.startAnimation(fabOpen)
                fabSwim.startAnimation(fabOpen)
                fab.startAnimation(fabRCClockwise)

                fabHike.isClickable
                fabBike.isClickable
                fabSwim.isClickable

                isOpen = true
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_about -> {
                findNavController(R.id.nav_host_fragment).navigate(R.id.action_global_to_about)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}