package psn.austus.maple.tree.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import psn.austus.maple.tree.response.SpeakResponse;

@FeignClient(name = "maple-tree-svc",url = "${feign.url.maple-tree-svc:}")
public interface TalkService {


    @GetMapping("/speak")
    public SpeakResponse speak(@RequestParam("arg") String arg);
}
