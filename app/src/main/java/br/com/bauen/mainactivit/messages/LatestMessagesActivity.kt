//package com.letsbuildthatapp.kotlinmessenger.messages
//
//import android.content.Intent
//import android.support.v7.app.AppCompatActivity
//import android.os.Bundle
//import android.support.v7.widget.DividerItemDecoration
//import android.util.Log
//import android.view.Menu
//import android.view.MenuItem
//import com.letsbuildthatapp.kotlinmessenger.R
//import com.letsbuildthatapp.kotlinmessenger.models.ChatMessage
//import com.letsbuildthatapp.kotlinmessenger.models.User
//import com.letsbuildthatapp.kotlinmessenger.registerlogin.RegisterActivity
//import com.letsbuildthatapp.kotlinmessenger.views.LatestMessageRow
//
//import com.xwray.groupie.GroupAdapter
//import com.xwray.groupie.Item
//import com.xwray.groupie.ViewHolder
//import kotlinx.android.synthetic.main.activity_latest_messages.*
//import kotlinx.android.synthetic.main.latest_message_row.view.*
//
//class LatestMessagesActivity : AppCompatActivity() {
//
//  companion object {
//    var currentUser: User? = null
//    val TAG = "LatestMessages"
//  }
//
//  override fun onCreate(savedInstanceState: Bundle?) {
//    super.onCreate(savedInstanceState)
//    setContentView(R.layout.activity_latest_messages)
//
//    recyclerview_latest_messages.adapter = adapter
//    recyclerview_latest_messages.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
//
//    // set item click listener on your adapter
//    adapter.setOnItemClickListener { item, view ->
//      Log.d(TAG, "123")
//      val intent = Intent(this, ChatLogActivity::class.java)
//
//      // we are missing the chat partner user
//
//      val row = item as LatestMessageRow
//      intent.putExtra(NewMessageActivity.USER_KEY, row.chatPartnerUser)
//      startActivity(intent)
//    }
//
////    setupDummyRows()
//    listenForLatestMessages()
//
//    fetchCurrentUser()
//
//    verifyUserIsLoggedIn()
//  }
//
//  val latestMessagesMap = HashMap<String, ChatMessage>()
//
//  private fun refreshRecyclerViewMessages() {
//    adapter.clear()
//    latestMessagesMap.values.forEach {
//      adapter.add(LatestMessageRow(it))
//    }
//  }
//
//  private fun listenForLatestMessages() {
//    val fromId = FirebaseAuth.getInstance().uid
//    val ref = FirebaseDatabase.getInstance().getReference("/latest-messages/$fromId")
//    ref.addChildEventListener(object: ChildEventListener {
//      override fun onChildAdded(p0: DataSnapshot, p1: String?) {
//        val chatMessage = p0.getValue(ChatMessage::class.java) ?: return
//        latestMessagesMap[p0.key!!] = chatMessage
//        refreshRecyclerViewMessages()
//      }
//
//      override fun onChildChanged(p0: DataSnapshot, p1: String?) {
//        val chatMessage = p0.getValue(ChatMessage::class.java) ?: return
//        latestMessagesMap[p0.key!!] = chatMessage
//        refreshRecyclerViewMessages()
//      }
//
//      override fun onChildMoved(p0: DataSnapshot, p1: String?) {
//
//      }
//      override fun onChildRemoved(p0: DataSnapshot) {
//
//      }
//      override fun onCancelled(p0: DatabaseError) {
//
//      }
//    })
//  }
//
//  val adapter = GroupAdapter<ViewHolder>()
//
////  private fun setupDummyRows() {
////
////
////    adapter.add(LatestMessageRow())
////    adapter.add(LatestMessageRow())
////    adapter.add(LatestMessageRow())
////  }
//
//      override fun onDataChange(p0: DataSnapshot) {
//        currentUser = p0.getValue(User::class.java)
//        Log.d("LatestMessages", "Current user ${currentUser?.profileImageUrl}")
//      }
//    })
//  }
//
//  }
//
//  override fun onOptionsItemSelected(item: MenuItem?): Boolean {
//    when (item?.itemId) {
//      R.id.menu_new_message -> {
//        val intent = Intent(this, NewMessageActivity::class.java)
//        startActivity(intent)
//      }
//
//    }
//
//    return super.onOptionsItemSelected(item)
//  }
//
//  override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//    menuInflater.inflate(R.menu.nav_menu, menu)
//    return super.onCreateOptionsMenu(menu)
//  }
//
//}
