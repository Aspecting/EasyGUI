# EasyGUI
EasyGUI is an event-driven Chest GUI API for Bukkit. You may create chest GUIs, join servers, send messages to players, and other custom actions whenever the respective event is invoked. Additionally, events support mutiple actions e.g. MyEvent can open an inventory *and* message the player.

## Getting Started
### Developers
First, we need an instance of the EasyGUI plugin. This will allow you to register and manage events, as well as create custom events.
```
EasyGUI guiPlugin = null;
Plugin plugin = getServer().getPluginManager().getPlugin("EasyGUI");
if(plugin == null || !(plugin instanceof EasyGUI)) {
  log.severe("Couldn't find EasyGUI!");
} else {
  guiPlugin = plugin;
}
```
**While storage is handled for `inventory`, `join` and `message`, you must (as of now) provide a Storage implementation to store your custom event internally.** 
To register a custom event, get the EasyGUIHandler instance from `getHandler()` in your EasyGUI object, then use `registerEvent(EventData)` to register an event. This action will be executed when the event is invoked, along with any other actions that are registered to that event.

Example:
```
Logger log = getLogger();
EasyGUIHandler guiHandler = guiPlugin.getHandler();
guiHandler.registerEvent("MyEvent", (event, player) -> log.info(player.getName() + " just invoked " + event + "!"))
```
### Server Managers
Please refer to the [Mongo connection URI format](https://docs.mongodb.com/manual/reference/connection-string/) while setting up the config.

