# Instagram-Like Feed App

This project is a simplified Instagram-like feed for a mobile application, where users can scroll through posts that contain either images, videos, or a combination of both. It demonstrates how to handle mixed media, optimize scrolling performance, and implement proper caching strategies to enhance user experience.

## Features

- **Scroll Feeds**: The app features a static, scrollable feed, displaying posts that consist of a single photo, a single video, or a combination of both.
- **Auto Play and Pause Videos**: Videos automatically start playing when they are visible on the screen, and they pause when they are scrolled out of view. This ensures optimal performance and prevents unnecessary resource consumption.
- **Caching Mechanism**: Implemented caching for both images and videos to improve loading performance and reduce resource overhead. Videos are locally stored in the `raw` folder, and caching is handled by ExoPlayer.
- **Efficient Scrolling**: The feed is implemented using `LazyColumn`, which efficiently loads only the visible items in the feed to improve scrolling performance.
- **Proper Resource Management**: ExoPlayer is properly disposed of when resources are not in use, ensuring no memory leaks and efficient resource management.

## Technologies Used

- **Kotlin**: For building the application logic.
- **Jetpack Compose**: For creating a modern, responsive UI.
- **ExoPlayer**: For handling video playback and caching.
- **SimpleCache**: A caching mechanism for video and image data to improve performance.
- **LazyColumn**: A performance-optimized list for displaying the feed.

## How It Works

### Feed Posts

Each post in the feed can display:
- A **single photo**, fetched from the locally stored images.
- A **single video**, fetched from the locally stored video resources.
- A **combination of both** — photo and video — bundled together as part of the same post.

### Video Playback

- Videos are automatically played when they become visible in the viewport.
- When a video scrolls out of the viewport, it pauses to conserve resources.
- This is achieved by using the `ExoPlayer` library, which allows easy media playback and management.

### Caching Mechanism

To optimize loading performance and reduce resource consumption, a caching mechanism is implemented:
- **Image Caching**: Images are loaded and cached from local resources using Coil.
- **Video Caching**: Videos are stored and cached using `ExoPlayer`'s `CacheDataSourceFactory`, which ensures that once a video is loaded, it is cached for future use. This prevents re-downloading and improves playback speed.

### ExoPlayer Management

- Proper management of the `FeedsExoPlayer` instance is handled in the app:
  - ExoPlayer is prepared and started when the video becomes visible in the feed.
  - ExoPlayer is released when the post is no longer in view, ensuring proper disposal and memory management.
  
### Scrolling Performance

The app uses a `LazyColumn`, which is a performance-optimized list in Jetpack Compose. It ensures that only the visible items in the feed are rendered, improving scrolling performance for long lists of posts. Also the unique key is provided to ensure optimize state preservation, performance, insertion/removal and recomposition

### Resource Management

- `FeedsExoPlayer` is used to play and pause videos efficiently.
- Videos that are not visible in the viewport are paused to free up resources.
- Caching ensures that videos are stored locally and do not need to be re-downloaded.

