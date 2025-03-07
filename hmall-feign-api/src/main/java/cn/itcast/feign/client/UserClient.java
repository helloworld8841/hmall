package cn.itcast.feign.client;
import cn.itcast.hmall.pojo.user.Address;
import cn.itcast.hmall.pojo.user.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
@FeignClient("userservice")
public interface UserClient {
    @GetMapping("/address/{addressId}")
    public Address getAddressID(@PathVariable("addressId")Long id);
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id")Long id);
    @RequestMapping("/user/pay/{money}/{id}")
    public void  pay(@PathVariable("money")Long money,@PathVariable("id")Long id);
}
