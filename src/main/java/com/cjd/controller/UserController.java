package com.cjd.controller;

import com.cjd.senddemo.AsyncSend;
import com.cjd.senddemo.ReqGen;
import com.cjd.service.ReqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cjd.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.LockSupport;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private ReqService reqService;
    ReqGen reqGen = new ReqGen();

    volatile int insertI = 0;
    volatile int updateI = 0;

    @RequestMapping("/test")
    @ResponseBody
    public String test(Model model,HttpServletRequest request){
        //return "hello world";
        //model.addAttribute("user",4);
        //return userService.findAll();

        return userService.findAll().toString();
    }

    @GetMapping("/get")
    public String get(Model model,HttpServletRequest request){
        System.out.println(request);
        System.out.println(request.getParameter("param"));
        System.out.println(request.getParameter("page_no"));
        return null;
    }

    @RequestMapping("insert")
    public String insert(){
        //int res = reqService.insert()

        AsyncSend asyncSend = new AsyncSend();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                asyncSend.insertReq();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                asyncSend.updateReq();
            }
        });

        t1.start();
        t2.start();
        return "success";
    }


    @RequestMapping("/qqqq")
    public void insertReq() {
        //ThreadPoolExecutor = new
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        System.out.println("now in insertReq");
        int loop = 1000;
        //int i = 0;
        while (insertI < 1000) {
            threadPool.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10);
                        System.out.println(reqService.insert(reqGen.getNewReq(1)));

                        System.out.println("insert" + insertI);
                        insertI++;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            });
        }
    }

    @RequestMapping("/aaaa")
    public void oneReq() {
        //ThreadPoolExecutor = new
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        System.out.println("now in insertReq");

        reqService.update(reqGen.getUpdateReq(0,1));
        //System.out.println(reqService.insert(reqGen.getNewReq(1)));
        System.out.println("insert" + insertI);




    }

    @RequestMapping("/loop")
    public void loopReq() {
        //ThreadPoolExecutor = new
        System.out.println("now in updateReq");
        ExecutorService threadPool = Executors.newFixedThreadPool(3);


        threadPool.submit(new Runnable() {
            @Override
            public void run() {
                    //LockSupport.parkNanos(100);
                    for(int i = 0 ; i < 1000 ; ++i) {
                        //LockSupport.parkNanos(10);
                        reqService.insert(reqGen.getNewReq(1));
                        System.out.println("insert" + i);

                    }

                }
            });
        threadPool.submit(new Runnable() {
            @Override
            public void run() {
                for(int i = 0 ; i < 1000 ; ++i) {
                    //LockSupport.parkNanos(5);
                    reqService.insert(reqGen.getNewReq(1));
                    System.out.println("insert" + i);

                }
            }
        });

        threadPool.submit(new Runnable() {
            @Override
            public void run() {
                for(int i = 0 ; i < 1001 ; ++i) {
                    //LockSupport.parkNanos(5);
                    reqService.insert(reqGen.getNewReq(1));
                    System.out.println("insert" + i);

                }
            }
        });
        threadPool.submit(new Runnable() {
            @Override
            public void run() {
                for(int i = 0 ; i < 1001 ; ++i) {
                    LockSupport.parkNanos(5);
                    //reqService.update(reqGen.getNewReq());
                    reqService.update(reqGen.getUpdateReq(0,i));
                    System.out.println("update" + i);

                }
            }
        });

        }





    @RequestMapping("/eeee")
    public void updateReq() {
        //ThreadPoolExecutor = new
        System.out.println("now in updateReq");
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        int loop = 1000;
        //int i = 0;
        while (updateI < 1000) {
            threadPool.submit(new Runnable() {
                @Override
                public void run() {
                    //LockSupport.parkNanos(100);
                    try {
                        Thread.sleep(200);
                        reqService.update(reqGen.getUpdateReq(0,1));
                        System.out.println("update" + updateI);
                        updateI++;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            });
        }
    }


}
