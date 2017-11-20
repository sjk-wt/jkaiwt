# 所有支持的编码格式

1. MP3
Since some browsers use the Flash element of jPlayer, the MP3 files used must be encoded according to the browser's Adobe Flash Plugin limitations:
Constant Bitrate Encoded.

Sample Rate a multiple of 11,025Hz. ie., 22,050Hz and 44,100Hz are valid sample rates.

2. M4A / M4V
The MP4 file is a container that supports both audio and video. The M4A format is an audio MP4, and the M4V format is a video MP4. The recommended encoding options for standard and mobile browsers are:

H.264 Baseline Profile Level 3.0 video, up to 640 x 480 at 30 fps. Note that B frames are not supported in the Baseline profile.
AAC-LC audio, up to 48 kHz.
The metadata should be at the start of the encoded data, since the Flash solution must have the metadata in order to begin playling. The option for this varies from encoder to encoder, but usually refers to optimizing for either web or streaming. This 3rd party link might help if you are having problems with the metadata: MetaData Mover

3. OGA / OGV
The OGG file is a container that supports both audio and video. The OGA format is an audio OGG, and the OGV format is a video OGG. The Vorbis and Theora codecs appear to have full support.

4. WEBMA / WEBMV
The WebM file is a container that supports both audio and video. The WEBMA format is an audio WebM, and the WEBMV format is a video WebM. The Vorbis and VP8 codecs appear to have full support.

5. WAV
The WAV format is supported by many HTML5 browsers. We recommend that you avoid it though as a counterpart format. The recommended encoding options are:

8-bit and 16-bit linear PCM
Only codec "1" (PCM) is supported.

6. FLA / FLV
The Flash FLV file is a container that supports both audio and video. The FLA format is an audio FLV, and the FLV format is a video FLV. The FLA/FLV format is supported by the Flash fallback.

7. RTMPA / RTMPV
The RTMP protocol uses a Flash Media Server (FMS) to stream media to jPlayer's Flash solution. The RTMPA format is an audio RTMP stream, and the RTMPV format is a video RTMP stream. The HTML solution does not support RTMP.

8. M3U8A / M3U8V
The M3U8 playlist format is an Apple HLS (HTTP Live Streaming) file. m3u8a for audio and m3u8v for video. This format works well on Apple devices and browsers (Safari), but has limited support elsewhere.

9. M3UA / M3UV
The M3U playlist format is am MPEG URL file. m3ua for audio and m3uv for video.

10. FLAC
The flac audio format.