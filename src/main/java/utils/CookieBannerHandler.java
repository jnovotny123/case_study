package utils;

import com.codeborne.selenide.Selenide;

public class CookieBannerHandler {
    private final int maxRetries = 3;
    private final int waitBetweenRetriesMs = 2000;

    public void acceptCookies() {
        System.out.println("👉 Spouštím cookie potvrzovací event...");

        for (int attempt = 1; attempt <= maxRetries; attempt++) {
            System.out.println("🔁 Pokus " + attempt + "/" + maxRetries);

            try {
                Object button = Selenide.executeJavaScript(
                        "return document.querySelector('#usercentrics-cmp-ui')?.shadowRoot" +
                                "?.querySelector(\"button[data-action-type='accept']\")"
                );

                if (button != null) {
                    Selenide.executeJavaScript("arguments[0].click();", button);
                    System.out.println("✅ Cookies byly potvrzeny.");
                    return;
                } else {
                    System.out.println("❌ Accept button zatím není dostupný.");
                }

            } catch (Exception e) {
                System.out.println("⚠️ Chyba při přístupu k cookies: " + e.getMessage());
            }

            Selenide.sleep(waitBetweenRetriesMs);
        }

        System.out.println("❌ Nepodařilo se potvrdit cookies po " + maxRetries + " pokusech.");
    }
}
