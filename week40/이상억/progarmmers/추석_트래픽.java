import java.util.*;

class Solution {

    static class Log{
        int start;
        int end;

        Log(int start, int end){
            this.start = start;
            this.end = end;
        }
    }


    static Log parse(String line){
        String[] parts = line.split(" ");

        String[] time = parts[1].split(":");

        int hh = Integer.parseInt(time[0]);
        int mm = Integer.parseInt(time[1]);

        String[] sec = time[2].split("\\.");
        int ss = Integer.parseInt(sec[0]);
        int ms = Integer.parseInt(sec[1]);

        int endMs = hh * 3600000 +
                mm * 60000 +
                ss * 1000 +
                ms;

        double durationSec = Double.parseDouble(
                parts[2].substring(0, parts[2].length() - 1)
        );

        int durationMs = (int)(durationSec * 1000);

        int startMs = endMs - durationMs + 1;

        return new Log(startMs, endMs);

    }


    public int solution(String[] lines) {
        int answer = 0;

        List<Log> logs = new ArrayList<>();

        for(String line : lines){
            logs.add(parse(line));
        }

        for(Log base : logs){
            int windowStart = base.end;
            int windowEnd = base.end + 999;

            int count = 0;
            for(Log target : logs){
                if(target.start <= windowEnd && target.end >= windowStart){
                    count ++;
                }
            }

            answer = Math.max(answer, count);
        }
        return answer;
    }
}

// window :      [======]
// target :  [-----------]
